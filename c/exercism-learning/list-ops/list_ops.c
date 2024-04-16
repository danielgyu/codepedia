#include "list_ops.h"
#include <assert.h>
#include <stdio.h>


list_t *new_list(size_t length, list_element_t elements[]) {
  list_t *list = (list_t*) malloc(sizeof(list_t) + length * sizeof(int));
  list->length = length;

  if (elements == NULL) {
    return list;
  }
  else {
    for (size_t i=0; i<length; i++) {
      list->elements[i] = elements[i];
    }
    return list;
  }
}

list_t *append_list(list_t *list1, list_t *list2) {
  size_t total = list1->length + list2->length;

  list_t *appended_list = malloc(sizeof(list_t) + total*sizeof(int));
  appended_list->length = total;

  for (size_t i=0; i<list1->length; i++) {
    appended_list->elements[i] = list1->elements[i];
  }
  for (size_t i=0; i<list2->length; i++) {
    appended_list->elements[i+list1->length] = list2->elements[i];
  }

  return appended_list;
}

list_t *filter_list(list_t *list, bool (*filter)(list_element_t)) {
  list_t *filtered_list = malloc(sizeof(list_t) + list->length*sizeof(int));

  int filtered_idx = 0;
  int filtered_count = 0;

  for (size_t i=0; i<list->length; i++) {
    if (filter(list->elements[i]) == 1) {
      filtered_list->elements[filtered_idx] = list->elements[i];
      filtered_idx++;
      filtered_count++;
    }
  }

  filtered_list->length = filtered_count;
  filtered_list = realloc(filtered_list, sizeof(list_t) + filtered_count * sizeof(int));
  return filtered_list;
}

size_t length_list(list_t *list) {
  return list->length;
}

list_t *map_list(list_t *list, list_element_t (*map)(list_element_t)) {
  list_t *mapped_list = malloc(sizeof(list_t) + list->length*sizeof(int));

  for (size_t i=0; i<list->length; i++) {
    mapped_list->elements[i] = map(list->elements[i]);
  }

  mapped_list->length = list->length;
  return mapped_list;
}

list_element_t foldl_list(list_t *list, list_element_t initial,
                          list_element_t (*foldl)(list_element_t,
                                                  list_element_t)) {
  list_element_t ret = initial;
  for (size_t i=0; i<list->length; i++) {
    ret = foldl(list->elements[i], ret);
  }
  return ret;
}

list_element_t foldr_list(list_t *list, list_element_t initial,
                          list_element_t (*foldr)(list_element_t,
                                                  list_element_t)) {
  list_element_t ret = initial;
  for (int i=(int)list->length-1; i>=0; i--) {
    ret = foldr(list->elements[i], ret);
  }
  return ret;
}

list_t *reverse_list(list_t *list) {
  list_t *reversed_list = malloc(sizeof(list_t) + list->length*sizeof(int));
  reversed_list->length = list->length;

  if (list->length == 0) {

    return reversed_list;
  }

  size_t left = 0;
  size_t right = list->length-1;
  assert(list->length == reversed_list->length);

  while (left < list->length) {
    reversed_list->elements[left++] = list->elements[right--];
  }

  return reversed_list;
}

void delete_list(list_t *list) {
  free(list);
}
