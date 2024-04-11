#include <stdio.h>
#include <string.h>

#include "grade_school.h"


void init_roster(roster_t *roster) {
  roster->count = 0;
}


void print_students(roster_t *roster) {
  for (size_t i=0; i<roster->count; i++) {
    student_t s = roster->students[i];
    printf("grade:%d | name:%s\n", s.grade, s.name);
  }
}


void sort_by_grade_and_name(roster_t *roster) {
  if (roster->count <= 0) {
    return;
  }
  printf("before:::\n");
  print_students(roster);

  // sort by grade
  for (size_t i=0; i<roster->count; i++) {
    uint8_t min_grade = roster->students[i].grade;
    size_t min_idx = i;

    for (size_t j=i+1; j<roster->count; j++) {
      student_t current_student = roster->students[j];
      if (current_student.grade < min_grade) {
        min_idx = j;
      }
    }

    student_t temp = roster->students[i];
    roster->students[i] = roster->students[min_idx];
    roster->students[min_idx] = temp;
  }
  printf("after sort by grade:::\n");
  print_students(roster);

  // get all grades
  int idx_by_grade[6] = {0};
  int grade_idx = 0;

  int l_grade = roster->students[0].grade;
  for (size_t i=1; i<roster->count; i++) {
    int r_grade = roster->students[i].grade;

    if (r_grade > l_grade) {
      idx_by_grade[grade_idx++] = i;
      l_grade = r_grade;
    }
  }
  idx_by_grade[grade_idx++] = roster->count;
  for (int i=0; i<grade_idx; i++){
    printf("idx_by_grade[%d]: %d\n", i, idx_by_grade[i]);
  }

  // sort by name
  int start = 0;
  for (int i=0; i<grade_idx; i++) {
    printf("i=%d, start=%d, idx_by_grade[i]=%d\n", i, start, idx_by_grade[i]);
    for (int j=start; j<idx_by_grade[i]-1; j++) {
        printf("j=%d, until=%d\n", j, idx_by_grade[i]-1);
        for (int k=start; k<idx_by_grade[i]-1; k++) {
          student_t l_student = roster->students[k];
          student_t r_student= roster->students[k+1];
          printf("comparing %s and %s\n", l_student.name, r_student.name);
          if (strcmp(l_student.name, r_student.name) > 0) {
            printf("switching %s and %s\n", l_student.name, r_student.name);
            student_t temp = roster->students[k];
            roster->students[k] = roster->students[k+1];
            roster->students[k+1] = temp;
        }
      }
    }
    printf("sort loop:::\n");
    print_students(roster);
    start = idx_by_grade[i];
  }
  printf("\n\n\n");
}


int add_student(roster_t *roster, char name[], uint8_t grade) {
  // dont' add if already reached max student count
  if (roster->count >= MAX_STUDENTS) {
    return 0;
  }

  // don't add if over max name length
  if (strlen(name) > MAX_NAME_LENGTH) {
    return 0;
  }

  // dont' add if student name already added
  for (size_t i=0; i<roster->count; i++) {
    if (strcmp(roster->students[i].name, name)==0) {
      return 0;
    }
  }

  // add student
  student_t student;
  student.grade = grade;
  strncpy(student.name, name, MAX_NAME_LENGTH);

  roster->students[roster->count] = student;
  roster->count++;

  sort_by_grade_and_name(roster);

  return 1;
}


roster_t get_grade(roster_t *roster, uint8_t desired_grade) {
  roster_t desired_roster;
  desired_roster.count = 0;

  for (size_t i=0; i<roster->count; i++) {
    if (roster->students[i].grade == desired_grade) {
      student_t student = roster->students[i];

      desired_roster.students[desired_roster.count] = student;
      desired_roster.count++;
    }
  }

  return desired_roster;
}
