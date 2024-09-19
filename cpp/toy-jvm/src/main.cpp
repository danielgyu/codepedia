#include "ClassParser.hpp"

int main() {
  ClassParser parser{
      "/home/kungyu/Development/codepedia/cpp/toy-jvm/classfiles/Add.class"};
  parser.parse();
}
