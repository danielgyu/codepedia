#include "rational_numbers.h"
#include <math.h>
#include <stdio.h>
#include <stdlib.h>


rational_t add(rational_t n1, rational_t n2) {
  rational_t res;
  res.numerator = (n1.numerator * n2.denominator + n2.numerator * n1.denominator);
  res.denominator = (n1.denominator * n2.denominator);
  if (res.numerator == 0) {
    res.denominator = 1;
  }
  //printf("numerator=%d | denominator=%d\n", res.numerator, res.denominator);
  return res;
}

rational_t subtract(rational_t n1, rational_t n2) {
  rational_t res;
  res.numerator = (n1.numerator * n2.denominator - n2.numerator * n1.denominator);
  res.denominator = (n1.denominator * n2.denominator);
  if (res.numerator == 0) {
    res.denominator = 1;
  }
  //printf("numerator=%d | denominator=%d\n", res.numerator, res.denominator);
  return res;
}

rational_t multiply(rational_t n1, rational_t n2) {
  rational_t res;
  res.numerator = (n1.numerator * n2.numerator);
  res.denominator = (n1.denominator * n2.denominator);
  res = reduce(res);
  if (res.numerator == 0) {
    res.denominator = 1;
  }
  clean(&res);
  return res;
}

rational_t divide(rational_t n1, rational_t n2) {
  rational_t res;
  res.numerator = (n1.numerator * n2.denominator);
  res.denominator = (n1.denominator * n2.numerator);
  res = reduce(res);
  clean(&res);
  return res;
}

rational_t absolute(rational_t n1) {
  rational_t res;
  res.numerator = abs(n1.numerator);
  res.denominator = abs(n1.denominator);
  res = reduce(res);
  clean(&res);
  return res;
}

rational_t exp_rational(rational_t n1, int16_t n2) {
  rational_t res;
  if (n2 == (int)n2) {
    if (n2 >= 0) {
      res.numerator = pow(n1.numerator, n2);
      res.denominator = pow(n1.denominator, n2);
    } else {
      res.numerator = pow(n1.denominator, abs(n2));
      res.denominator = pow(n1.numerator, abs(n2));
    }
  } else {
    res.numerator = pow(n1.numerator, n2);
    res.denominator = pow(n1.denominator, n2);
  }
  clean(&res);
  return res;
}

float exp_real(uint16_t n1, rational_t n2) {
  float p, q;
  p = pow(n1, n2.numerator);
  q = n2.denominator;
  return pow(p, 1/q);
}

rational_t reduce(rational_t n) {
  int gcd = 1;
  for (int i=2; i<=abs(n.denominator) && i<=abs(n.numerator); i++) {
    if (n.denominator%i==0 && n.numerator%i==0) {
      gcd = i;
    }
  }
  n.denominator = n.denominator / gcd;
  n.numerator= n.numerator/ gcd;
  clean(&n);
  return n;
}

void clean(rational_t *res) {
  if (res->numerator == 0) {
    res->denominator = 1;
  }
  if (res->numerator < 0 && res->denominator < 0) {
    res->numerator = -1 * res->numerator;
    res->denominator = -1 * res->denominator;
  }
  if (res->numerator > 0 && res->denominator < 0) {
    res->numerator = -1 * res->numerator;
    res->denominator = -1 * res->denominator;
  }
}
