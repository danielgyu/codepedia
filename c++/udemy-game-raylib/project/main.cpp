#include <stdio.h>

#include "raylib.h"

int main()
{
    int width = 350;
    int length = 700;

    InitWindow(width, length, "kungyu's window");
    SetTargetFPS(30);

    while (true) {
        BeginDrawing();
        ClearBackground(WHITE);
        EndDrawing();
    }
}