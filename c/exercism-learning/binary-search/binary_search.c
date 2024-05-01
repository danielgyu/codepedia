#include "binary_search.h"
#include <stdio.h>


const int *binary_search(int value, const int *arr, size_t length) {
  int left = 0;
  int right = length;

  while (left < right) {
    int mid = (left+right) / 2;
    int cur = arr[mid];
    printf("left=%d, right=%d, mid=%d\n", left , right, mid);

    if (cur == value) {
      return &arr[mid];
    }
    else if (cur > value) {
      right = mid;
    } else {
      left = mid+1;
    }
  }

  return NULL;
}
