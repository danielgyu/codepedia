#include <string.h>
#include "hamming.h"

int compute(const char *lhs, const char *rhs) {
  if (strlen(lhs) != strlen(rhs)) {
    return -1;
  }

  int distance = 0;
  for (size_t i=0; i<strlen(lhs); i++) {
    if (lhs[i] != rhs[i]) {
      distance += 1;
    }
  }
  return distance;
}
