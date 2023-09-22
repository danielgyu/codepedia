ORG 0x7C00  ; BIOS loads the bootloader to 0x7C00
BITS 16  ; bootloader uses 16-bit architecture

start:
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
