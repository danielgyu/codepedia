#include "ClassParser.hpp"
#include <memory>

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

  // printHexdump(array_size, array);
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
  int idx = 0;
  ClassFile classFile;

  copyVectorElementsToArray(4, classFile.magic, content, idx, idx + 4);
  idx += 4;

  copyVectorElementsToArray(2, classFile.minor_version, content, idx, idx + 2);
  idx += 2;

  copyVectorElementsToArray(2, classFile.major_version, content, idx, idx + 2);
  idx += 2;

  copyVectorElementsToArray(2, classFile.constant_pool_count, content, idx,
                            idx + 2);
  idx += 2;

  uint16_t constant_pool_count_decimal =
      ((static_cast<uint8_t>(classFile.constant_pool_count[0]) << 8) |
       static_cast<uint8_t>(classFile.constant_pool_count[1])) -
      1;
  CPInfo constant_pools[constant_pool_count_decimal];
  for (size_t i = 0; i < constant_pool_count_decimal; i++) {
    // for (size_t i = 0; i < 4; i++) {
    std::unique_ptr<CPInfo> cp_info_ptr = std::make_unique<CPInfo>();

    auto tag = content[idx];

    switch (tag) {
    case 1: {
      std::cout << "INFO | tag: CONSTANT_Utf8" << std::endl;
      idx += 1;
      uint16_t utf8_length = ((static_cast<uint8_t>(content[idx]) << 8) |
                              static_cast<uint8_t>(content[idx + 1]));
      idx += 2;
      idx += utf8_length;
      break;
    }
    case 3:
      std::cout << "INFO | tag: CONSTANT_Integer" << std::endl;
      idx += 5;
      break;
    case 6:
      std::cout << "INFO | tag: CONSTANT_Double" << std::endl;
      idx += 9;
      break;
    case 7:
      std::cout << "INFO | tag: CONSTANT_Class" << std::endl;
      idx += 3;
      break;
    case 10:
      std::cout << "INFO | tag: CONSTANT_Methodref" << std::endl;
      idx += 5;
      break;
    case 12:
      std::cout << "INFO | tag: CONSTANT_NameAndType" << std::endl;
      idx += 5;
      break;
    default:
      std::cout << "INFO | not supported tag: " << (int)tag << std::endl;
      break;
    }
  }

  // looksl ike we've finished parsing constant pool
  // move on to parse access_flags
  std::cout << "idx at: " << idx << std::endl;
}
