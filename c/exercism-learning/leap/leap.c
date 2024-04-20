#include "leap.h"
#include <stdio.h>

bool leap_year(int year) {
  printf("\n\n");

  bool divisible1 = year % 4 == 0;
  bool divisible2 = (year % 100 == 0);
  bool divisible3 = (year % 400 == 0);

  printf("year=%d, by 4=%d, by 100=%d, by 400=%d\n", year, divisible1, divisible2, divisible3);

  return (divisible1 && !divisible2 && !divisible3) || (divisible1 && divisible2 && divisible3 );
}
