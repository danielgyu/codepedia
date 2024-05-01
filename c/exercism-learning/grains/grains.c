#include <math.h>
#include "grains.h"

uint64_t square(uint8_t index) {
  return pow(2, index-1);
}

uint64_t total() {
  int total = 0;
  for (int i=0; i<65; i++) {
    total += square(i);
  }
  return total;
}
