    processor 6502

    seg code
    org $F000

Start:
    sei
    cld
    ldx #$FF
    txs

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; CLear the Page Zero region with ($00 to $FF)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

    lda $0
    ldx #$FF
	sta $FF

Loop:
    ;x--, DEX is a instruction that sets flags(including z)
    dex  

    ; store the value of A to memory $0 + X
    sta $0,X

    ;branch to loop if z flag is not zero
    bne Loop


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;  FIll the ROM size to exactly 4KB (to close the cartridge)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    org $FFFC
    .word Start
    .word Start
