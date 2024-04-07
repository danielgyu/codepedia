#include <stdio.h>
#include <string.h>
#include "isogram.h"


bool is_isogram(const char phrase[]) {
  if (phrase == NULL) {
    return false;
  }

  int alpha_counter[1024] = {0};

  for (size_t i=0; i<strlen(phrase); i++) {
    int ascii = (int) phrase[i];
    if (ascii >= 65 && ascii <= 90) {
      ascii += 32;
    }

    if (alpha_counter[ascii] != 0 && ascii != 45 && ascii != 32) {
      return false;
    }
    alpha_counter[ascii] += 1;
  }
  return true;
}
