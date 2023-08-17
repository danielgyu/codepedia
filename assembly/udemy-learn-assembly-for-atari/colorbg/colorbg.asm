	processor 6502

	include "vcs.h"
	include "macro.h"

	seg code
	org $F000

START:
	CLEAN_START

	; load the value of color yellow(#$1E) to A
	lda #$1E

	; store A to COLUBK(address of background color)
	sta COLUBK

	jmp START

	org $FFFC
	.word START
	.word START
