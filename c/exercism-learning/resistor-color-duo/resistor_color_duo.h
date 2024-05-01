#ifndef RESISTOR_COLOR_DUO_H
#define RESISTOR_COLOR_DUO_H

#include <stdint.h>

enum band_color {
  BLACK,
  BROWN,
  RED,
  ORANGE,
  YELLOW,
  GREEN,
  BLUE,
  VIOLET,
  GREY,
  WHITE
};

typedef enum band_color resistor_band_t;

uint16_t color_code(resistor_band_t colors[]);

#endif
