#include "space_age.h"

float age(planet_t planet, int64_t seconds) {
  float in_earth_years = (float) seconds / 86400 / 365.25; 

  switch(planet) {
    case MERCURY:
      return in_earth_years * (1.0 / 0.2408467);
    case VENUS:
      return in_earth_years * (1.0 / 0.61519726);
    case EARTH:
      return in_earth_years;
    case MARS:
      return in_earth_years * (1.0 / 1.8808158);
    case JUPITER:
      return in_earth_years * (1.0 / 11.862615);
    case SATURN:
      return in_earth_years * (1.0 / 29.447498);
    case URANUS:
      return in_earth_years * (1.0 / 84.016846);
    case NEPTUNE:
      return in_earth_years * (1.0 / 164.79132);
    default:
      return -1;
  }
}
