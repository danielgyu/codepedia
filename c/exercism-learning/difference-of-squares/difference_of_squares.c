#include <stdio.h>
#include <math.h>
#include "difference_of_squares.h"


unsigned int sum_of_squares(unsigned int number) {
  unsigned int n = number*(number+1)*(2*number+1) / 6;
  printf("sum_of_squares: %d\n", n);
  return n;
}


unsigned int square_of_sum(unsigned int number) {
  unsigned int n = pow((double) number*(number+1) / 2, 2);
  printf("square_of_sum: %d\n", n);
  return n;
}


unsigned int difference_of_squares(unsigned int number) {
  return (square_of_sum(number)-sum_of_squares(number));
}
