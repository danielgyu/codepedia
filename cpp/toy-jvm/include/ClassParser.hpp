#ifndef CLASS_PARSER_H
#define CLASS_PARSER_H

#include <cstdlib>
#include <fstream>
#include <iomanip>
#include <ios>
#include <iostream>
#include <stdexcept>
#include <string>
#include <tuple>
#include <vector>

struct CPInfo {
  char tag;
  char info[];
};

struct AttributeInfo {
  char attribute_name_index[2];
  char attribute_length[4];
  char info[];
};

struct FieldInfo {
  char access_flags[2];
  char name_index[2];
  char descriptor_index[2];
  char attributes_count[2];
  AttributeInfo attribute_info[];
};

struct MethodInfo {
  char access_flags[2];
  char name_index[2];
  char descriptor_index[2];
  char attributes_count[2];
  AttributeInfo attribute_info[];
};

struct ClassFile {
  char magic[4];
  char minor_version[2];
  char major_version[2];
  char constant_pool_count[2];
  CPInfo *constant_pool;
  char access_flags[2];
  char this_class[2];
  char super_class[2];
  char interfaces_count[2];
  char *interfaces;
  char fields_count[2];
  FieldInfo *fields;
  char methods_count[2];
  MethodInfo *methods;
  char attributes_count[2];
  AttributeInfo attributes[];
};

class ClassParser {
private:
  std::string m_file_path{};

  std::vector<char> read_file() const;

public:
  ClassParser(std::string file_path);

  void parse() const;
};

#endif
