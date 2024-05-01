#include "rna_transcription.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char *to_rna(const char *dna) {
  int length = strlen(dna);
  char* rna = malloc(sizeof(char) * (length+1));
  
  for (int i=0; i<length; i++) {
    switch (dna[i]) {
      case 'G':
        rna[i] = 'C';
        break;

      case 'C':
        rna[i] = 'G';
        break;

      case 'T':
        rna[i] = 'A';
        break;

      case 'A':
        rna[i] = 'U';
        break;
    }
  }
  rna[length] = 0;

  for (int i=0; i<length; i++) {
    printf("length=%d, rna[%d] = %c\n\n", length, i, rna[i]);
  }

  return rna;
}
