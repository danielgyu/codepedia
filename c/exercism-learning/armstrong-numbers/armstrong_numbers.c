#include <stdlib.h>
#include <math.h>
#include "armstrong_numbers.h"

bool is_armstrong_number(int candidate) {
  int num_of_digit = floor(log10(abs(candidate))) + 1;
  int total = 0;

  for (int i=0; i<num_of_digit; i++) {
    int remainder = candidate % 10;
    candidate /= 10;

    total += pow(remainder, num_of_digit);
  }

  return (candidate == total) ? true : false;
}
