ORG 0
BITS 16

_start:
	jmp short start
	nop

	times 33 db 0
start:
	jmp 0x7c0: step2

step2:
	;;; manually configure the segment registers
	;;; so that it could be BIOS-agnostic

	cli  ; clear interrupts to prevent to prevent any interruption

	; set up segments without any interruptions
	mov ax, 0x7c0
	mov ds, ax  ; set data segment as 0x7c0
	mov es, ax  ; set extra segment as 0x7c0

	mov ax, 0x00
	mov ss, ax  ; set stack segment as 0
	mov sp, 0x7c00  ; set stack pointer to 0x7c00

	sti  ; enable interrupts

	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	;AH = 02h
	;AL = number of sectors to read (must be nonzero)
	;CH = low eight bits of cylinder number
	;CL = sector number 1-63 (bits 0-5)
	;high two bits of cylinder (bits 6-7, hard disk only)
	;DH = head number
	;DL = drive number (bit 7 set for hard disk)
	;ES:BX -> data buffer

	;Return:
	;CF set on error
	;if AH = 11h (corrected ECC error), AL = burst length
	;CF clear if successful
	;AH = status (see #00234)
	;AL = number of sectors transferred (only valid if CF set for some
	; BIOSes)
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

	mov ah, 2  ; read sector command
	mov al, 1  ; one sector to read
	mov ch, 0  ; low eight bits of desired cyclinder number
	mov cl, 2  ; read sector two
	mov dh, 0  ; head number
	mov bx, buffer
	int 0x13
	jc error

	mov si, buffer
	call print

	jmp $

error:
	mov si, error_message
	call print
	jmp $

print:
	mov bx, 0  ; set page number to 0
.loop:
	lodsb  ; goes to the place where si register is pointing
	cmp al, 0  ; compare al register value to 0
	je .done  ; if it's 0 (after 'Hello World'), jump to done
	call print_char  ; else, call print_char subroutine
	jmp .loop

.done:
	ret

print_char:
	mov ah, 0eh
	int 0x10  ; calls(interrupts) the BIOS routine, prints cha rin AL
	ret

error_message: db 'Failed to load sector'

times 510-($ - $$) db 0
dw 0xAA55

buffer:
