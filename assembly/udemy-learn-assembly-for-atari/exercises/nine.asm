processor 6502
seg Code ; Define a new segment named "Code"
org $F000 ; Define the origin of the ROM code at memory address $F000

Start:
	lda #1 ; Initialize the A register with the decimal value 1

Loop:
	; Increment A
	clc
	adc #1

	; Compare the value in A with the decimal value 10
	cmp #10

	; Branch back to loop if the comparison was not equals (to zero)
	bne Loop

	org $FFFC ; End the ROM always at position $FFFC
	.word Start ; Put 2 bytes with reset address at memory position $FFFC
	.word Start ; Put 2 bytes with break address at memory position $FFFE
