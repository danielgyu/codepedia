#include <xc.h>

void main()
{
    ANSELBbits.ANSB1 = 0;
    TRISBbits.TRISB1 = 0;
    
    while (1) {
        LATBbits.LATB1 = 1;
        for (int i=0; i<400000; i++) {
            asm("nop");
        }
        LATBbits.LATB1 = 0;
        for (int i=0; i<400000; i++) {
            asm("nop");
        }
    }
}