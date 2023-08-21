    processor 6502

	include "vcs.h"
	include "macro.h"

	seg
	org $F000

Reset:
    CLEAN_START

	ldx #$80
	stx COLUBK

	lda #$1C
	sta COLUPF

StartFrame:
    lda #02
	sta VBLANK
	sta VSYNC

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; 3 lines of VSYNC
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

	REPEAT 3
	    sta WSYNC
	REPEND
	lda #0
	sta VSYNC

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; 37 lines of VBLANK
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

	REPEAT 37
	    sta WSYNC
	REPEND
	lda #0
	sta VBLANK

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; allow playfield reflection (set CTRLPF to 1)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
    ldx #1
	stx CTRLPF

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; draw the 192 visible scanlines
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

    ; 7 lines for empty outer
	ldx #0
	stx PF0
	stx PF1
	stx PF2
	REPEAT 7
	    sta WSYNC
	REPEND

	; 7 lines for the border
	ldx #%11100000
	stx PF0
	ldx #%11111111
	stx PF1
	stx PF2
	REPEAT 7
	    sta WSYNC
	REPEND

	; 164 for the actual field
	ldx #%01100000
	stx PF0
	ldx #0
	stx PF1
	ldx #%10000000
	stx PF2
	REPEAT 164
	    sta WSYNC
	REPEND

	; 7 lines for the border
	ldx #%11100000
	stx PF0
	ldx #%11111111
	stx PF1
	stx PF2
	REPEAT 7
	    sta WSYNC
	REPEND

	; 7 lines for empty outer
	ldx #0
	stx PF0
	stx PF1
	stx PF2
	REPEAT 7
	    sta WSYNC
	REPEND

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; 30 lines of VBLANK(overscan)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

    lda #2
	sta VBLANK
	REPEAT 30
	  sta WSYNC
	REPEND
	lda #0
	sta VBLANK

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Loop to next frame
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

	jmp StartFrame

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Complete ROM
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    org $FFFC
	.word Reset 
	.word Reset
