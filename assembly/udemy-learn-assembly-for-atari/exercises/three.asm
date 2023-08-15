	processor 6502
	seg Code ; Define a new segment named "Code"
	org $F000 ; Define the origin of the ROM code at memory address $F000

Start:
	; Load the A register with the literal decimal value 15
	lda #15

	; Transfer the value from A to X
	tax

	; Transfer the value from A to Y
	tay

	; Transfer the value from X to A
	txa

	; Transfer the value from Y to A
	tya

	; Load X with the decimal value 6
	ldx #6

	; Transfer the value from X to Y
	txa
	tay

	org $FFFC ; End the ROM by adding required values to memory position $FFFC
	.word Start ; Put 2 bytes with the reset address at memory position $FFFC
	.word Start ; Put 2 bytes with the break address at memory position $FFFE
