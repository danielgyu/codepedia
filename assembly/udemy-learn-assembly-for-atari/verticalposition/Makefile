compile:
	dasm verticalposition.asm -f3 -v0 -overticalposition.bin -lplayfield.lst -splayfield.sym

all:
	dasm *.asm -f3 -v0 -overticalposition.bin -lplayfield.lst -splayfield.sym
	stella verticalposition.bin

run:
	stella verticalposition.bin
