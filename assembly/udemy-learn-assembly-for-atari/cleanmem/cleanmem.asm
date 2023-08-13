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

Loop:
    ; store the value of A to memory $0 + X
    sta $0,X

    ;x--, DEX is a instruction that sets flags(including z)
    dex  

    ;branch to loop if z flag is not zero
    bne Loop


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;  FIll the ROM size to exactly 4KB (to close the cartridge)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    org $FFFC
    .word Start
    .word Start
