#ifndef RATIONAL_NUMBERS_H
#define RATIONAL_NUMBERS_H

#include <stdint.h>

typedef struct rational_t rational_t;

struct rational_t {
  int numerator;
  int denominator;
};  

rational_t add(rational_t n1, rational_t n2);

rational_t subtract(rational_t n1, rational_t n2);

rational_t multiply(rational_t n1, rational_t n2);

rational_t divide(rational_t n1, rational_t n2);

rational_t absolute(rational_t n1);

rational_t exp_rational(rational_t n1, int16_t n2);

float exp_real(uint16_t n1, rational_t n2);

rational_t reduce(rational_t n1);

void clean(rational_t *res);

#endif
