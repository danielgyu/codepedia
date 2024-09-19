#include "ClassParser.hpp"

void printHexdump(size_t size, char *array) {
  std::cout << "INFO | hexump: ";
  for (int i = 0; i < size; i++) {
    std::cout << std::hex << std::setw(2) << std::setfill('0') << (int)array[i]
              << " ";
  }
  std::cout << std::endl;
}

void copyVectorElementsToArray(size_t array_size, char *array,
                               std::vector<char> elements, size_t start,
                               size_t end) {
  size_t slice_size = end - start;
  if (slice_size > array_size)
    throw std::invalid_argument("ERR | wrong slice size");

  for (auto [i, j] = std::tuple{0, start}; i < array_size, j < end; i++, j++) {
    array[i] = elements[j];
  }

  printHexdump(array_size, array);
}

ClassParser::ClassParser(std::string file_path) : m_file_path{file_path} {}

std::vector<char> ClassParser::read_file() const {
  int SIZE = 1024;
  std::vector<char> content(SIZE);

  std::ifstream file(m_file_path, std::ios::binary | std::ios::ate);
  if (!file) {
    std::cerr << "Error opening file!" << std::endl;
    return content;
  }

  std::streamsize file_size = file.tellg();
  file.seekg(0, std::ios::beg);

  if (file.read(content.data(), SIZE)) {
    std::cout << "INFO | read all " << SIZE << " data" << std::endl;
  } else {
    std::cerr << "INFO | read " << file.gcount() << " data" << std::endl;
  }

  content.resize(file.gcount());
  return content;
}

void ClassParser::parse() const {
  auto content = read_file();

  std::cout << "INFO | classfile full hexdump: ";
  for (int i = 0; i < content.size(); i++) {
    std::cout << std::hex << std::setw(2) << std::setfill('0')
              << (int)content[i] << " ";
  }
  std::cout << std::endl;

  // start parsing
  ClassFile classFile;
  copyVectorElementsToArray(4, classFile.magic, content, 0, 4);
  copyVectorElementsToArray(2, classFile.minor_version, content, 4, 6);
  copyVectorElementsToArray(2, classFile.major_version, content, 6, 8);
  copyVectorElementsToArray(2, classFile.constant_pool_count, content, 8, 10);

  std::cout << "@@" << static_cast<int>(classFile.constant_pool_count[0]) << "."
            << std::endl;
}
