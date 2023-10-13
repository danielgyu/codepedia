#include <stdio.h>
#include "raylib.h"
#include "raymath.h"

int main()
{
    const int windowWidth{384};
    const int windowHeight{384};
    InitWindow(windowWidth, windowHeight, "classy-clash");

    Texture2D map = LoadTexture("nature_tileset/OpenWorldMap24x24.png");
    Vector2 mapPos{0.0, 0.0};
    float speed{4.0};

    /* knight */
    Texture2D knight_idle = LoadTexture("characters/knight_idle_spritesheet.png");
    Texture2D knight_run = LoadTexture("characters/knight_run_spritesheet.png");
    Vector2 knightPos{
        (float)windowWidth / 2.0f - 4.0f * (0.5f * (float)knight_idle.width / 6.0f),
        (float)windowHeight / 2.0f - 4.0f * (0.5f * (float)knight_idle.height)};

    /* knight direction (1:right, -1:left)*/
    float rightOrLeft{1.0f};

    /* animation */
    float runningTime{};
    int frame{};
    const int maxFrames{6};
    const float updateTime{1.f/12.f};

    SetTargetFPS(60);
    while (!WindowShouldClose())
    {
        BeginDrawing();
        ClearBackground(WHITE);

        /* movement*/
        Vector2 direction{};
        if (IsKeyDown(KEY_A)) direction.x -= 1.0;
        if (IsKeyDown(KEY_D)) direction.x += 1.0;
        if (IsKeyDown(KEY_W)) direction.y -= 1.0;
        if (IsKeyDown(KEY_S)) direction.y += 1.0;
        Texture2D knight;
        if (Vector2Length(direction) != 0.0)
        {
            // set mapPos = mapPos - direction
            knight = knight_run;
            mapPos = Vector2Subtract(mapPos, Vector2Scale(Vector2Normalize(direction), speed));
            direction.x < 0.f ? rightOrLeft = -1.f : rightOrLeft = 1.f;
        }
        else
        {
            knight = knight_idle;
        }

        /* draw map*/
        DrawTextureEx(map, mapPos, 0.0, 4.0, WHITE);
        
        /* update animation frame */
        runningTime += GetFrameTime();
        if (runningTime > updateTime)
        {
            frame++;
            runningTime = 0.f;
            if (frame > maxFrames) frame = 0;
        }

        /* draw character */
        Rectangle source{
            frame * (float)knight.width/6.f,
            0.f,
            rightOrLeft * (float)knight.width/6.f,
            (float)knight.height
        };
        Rectangle dest{knightPos.x, knightPos.y, 4.0f * (float)knight.width/6.0f, 4.0f * (float)knight.height};
        DrawTexturePro(knight, source, dest, Vector2{}, 0.f, WHITE);

        EndDrawing();
    }
    CloseWindow();
}