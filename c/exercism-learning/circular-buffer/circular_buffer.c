#include "circular_buffer.h"
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>

#define EMPTY -999


void print_buffer(circular_buffer_t *c_buffer) {
  printf("start: %d, end: %d, size: %d\n", c_buffer->start, c_buffer->end, c_buffer->size);
  for (size_t i=0; i<c_buffer->capacity; i++) {
    printf("%d\n", c_buffer->buffer[i]);
  }
  printf("\n");
}


circular_buffer_t* new_circular_buffer(size_t capacity) {
  circular_buffer_t* circular_buffer = malloc(sizeof(*circular_buffer));
  int* buffer = (int*) malloc(capacity * sizeof(int));

  circular_buffer->buffer = buffer;
  circular_buffer->capacity = capacity;
  circular_buffer->start = -1;
  circular_buffer->end = -1;
  circular_buffer->size = 0;

  return circular_buffer;
}


int16_t read(circular_buffer_t *c_buffer, buffer_value_t *value) {
  if (c_buffer->size == 0) {
    errno = ENODATA;
    return EXIT_FAILURE;
  }

  buffer_value_t v = c_buffer->buffer[c_buffer->start];
  *value = v;

  c_buffer->buffer[c_buffer->start] = EMPTY;

  c_buffer->start = (c_buffer->start + 1) % c_buffer->capacity;
  if (c_buffer->size == (int) c_buffer->capacity && c_buffer->end >= (int) c_buffer->capacity-1) {
    c_buffer->end = (c_buffer->end+1) % c_buffer->capacity;
  }

  c_buffer->size--;

  return EXIT_SUCCESS;
}


int16_t write(circular_buffer_t *c_buffer, buffer_value_t value) {
  // new buffer
  if (c_buffer->size == 0) {
    c_buffer->start=0;
    c_buffer->end=1;
    c_buffer->buffer[0] = value;
    c_buffer->size++;

    return EXIT_SUCCESS;
  }
  
  if (c_buffer->size >= (int)c_buffer->capacity) {
    errno = ENOBUFS;
    return EXIT_FAILURE;
  }

  c_buffer->buffer[c_buffer->end] = value;

  c_buffer->size++;

  if (c_buffer->size < (int) c_buffer->capacity) {
    c_buffer->end = (c_buffer->end + 1) % c_buffer->capacity;
  }

  return EXIT_SUCCESS;
}


int16_t overwrite(circular_buffer_t *c_buffer, buffer_value_t value) {
  if (c_buffer->size < (int) c_buffer->capacity) {
    write(c_buffer, value);
    return EXIT_SUCCESS;
  }

  c_buffer->start = (c_buffer->start+1) % c_buffer->capacity;
  c_buffer->end = (c_buffer->end+1) % c_buffer->capacity;

  c_buffer->buffer[c_buffer->end] = value;

  return EXIT_SUCCESS;
}


void clear_buffer(circular_buffer_t *c_buffer) {
  for (int i=0; i<c_buffer->size; i++) {
    c_buffer->buffer[i] = EMPTY;
  }
  c_buffer->start = 0;
  c_buffer->end = 1;
  c_buffer->size = 0;
}

void delete_buffer(circular_buffer_t *buffer) {
  free(buffer);
}
