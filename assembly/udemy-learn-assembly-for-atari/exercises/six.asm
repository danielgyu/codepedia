	processor 6502
	seg Code ; Define a new segment named "Code"
	org $F000 ; Define the origin of the ROM code at memory address $F000

Start:
	; Load the A register with the decimal value 1
	lda #1
	; Load the X register with the decimal value 2
	ldx #2
	; Load the Y register with the decimal value 3
	ldy #3

	; Increment X
	inx

	; Increment Y
	iny

	; Increment A
	clc
	adc #1

	; Decrement X
	dex

	; Decrement Y
	dey

	; Decrement A
	sec
	sbc #1

	org $FFFC ; End the ROM always at position $FFFC
	.word Start ; Put 2 bytes with reset address at memory position $FFFC
	.word Start ; Put 2 bytes with break address at memory position $FFFE
