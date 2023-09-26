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

	mov si, message  ; move our start of the message to the si register
	call print  ; call print subroutine
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

message: db 'Hello World!', 0

times 510-($ - $$) db 0
dw 0xAA55
