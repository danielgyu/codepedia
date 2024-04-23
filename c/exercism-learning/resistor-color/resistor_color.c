#include "resistor_color.h"
#include <stdlib.h>


uint16_t color_code(resistor_band_t band) {
  return band;
}

resistor_band_t* colors() {
  resistor_band_t* colors = malloc(COLOR_LENGTH * sizeof(uint16_t));
  for (int color=BLACK; color<=WHITE; color++) {
    colors[color] = color;
  }
  return colors;
}
