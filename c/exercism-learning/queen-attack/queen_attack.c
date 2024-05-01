#include "queen_attack.h"
#include <stdlib.h>

bool valid_position(position_t queen) {
  if (queen.row>7 || queen.column>7) {
    return false;
  }
  return true;
}


attack_status_t can_attack(position_t queen_1, position_t queen_2) {
  position_t queens[] = {queen_1, queen_2};
  for (int i=0; i<2; i++) {
    if (!valid_position(queens[i])) {
      return INVALID_POSITION;
    }
  }

  if (queen_1.row == queen_2.row && queen_1.column == queen_2.column) {
    return INVALID_POSITION;
  }

  if (queen_1.row == queen_2.row || queen_1.column == queen_2.column) {
    return CAN_ATTACK;
  }

  uint8_t row_diff = abs(queen_1.row - queen_2.row);
  uint8_t col_diff = abs(queen_1.column - queen_2.column);

  if (row_diff == col_diff) {
    return CAN_ATTACK;
  }

  return CAN_NOT_ATTACK;
}
