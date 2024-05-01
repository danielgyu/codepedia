#include "resistor_color_duo.h"

uint16_t color_code(resistor_band_t colors[]) {
  int color_nums[2] = {0};
  for (int i=0; i<2; i++) {
    if (i==0 && colors[i] == BLACK) {
      continue;
    }

    color_nums[i] = colors[i];
  }

  int j, k= 0;
  for (j=0; j<2; j++) {
    k = 10 * k + color_nums[j];
  }
  
  return k;
}
