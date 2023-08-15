	processor 6502
	seg Code ; Define a new segment named "Code"
	org $F000 ; Define the origin of the ROM code at memory address $F000

Start:
	; Load the A register with the literal decimal value 100
	lda #100

	; Add the decimal value 5 to the accumulator
	clc
	adc #5

	; Subtract the decimal value 10 from the accumulator
	sec
	sbc #10

	; Register A should now contain the decimal 95 (or $5F in hexadecimal)

	jmp Start

	org $FFFC ; End the ROM by adding required values to memory position $FFFC
	.word Start ; Put 2 bytes with the reset address at memory position $FFFC
	.word Start ; Put 2 bytes with the break address at memory position $FFFE
