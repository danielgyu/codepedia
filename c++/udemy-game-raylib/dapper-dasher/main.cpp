#include <stdio.h>
#include "raylib.h"

int main()
{
    const int windowWidth = 900;
    const int windowHeight= 700;
    InitWindow(windowWidth, windowHeight, "Dapper Dasher");
    SetTargetFPS(60);

    // check air
    bool isInAir{};
    
    // acceleration due to gravity (pixels/s)/s
    const int gravity{1'000};

    // time
    const float scarfyUpdateTime{1.0/12.0};
    float scarfyRunningTime{0};

    const float nebulaUpdateTime{1.0/12.0};
    float nebulaRunningTime{0};

    // scarfy
    Texture2D scarfy = LoadTexture("textures/scarfy.png");
    Rectangle scarfyRec;
    scarfyRec.width = scarfy.width / 6;
    scarfyRec.height = scarfy.height;
    scarfyRec.x = 0;
    scarfyRec.y = 0;
    Vector2 scarfyPos;
    scarfyPos.x = windowWidth/2 - scarfyRec.width/2;
    scarfyPos.y = windowHeight - scarfyRec.height;
    int scarfyVelocity{0};

    // nebula
    Texture2D nebula = LoadTexture("textures/12_nebula_spritesheet.png");
    Rectangle nebulaRec{0.0, 0.0, static_cast<float>(nebula.width/8), static_cast<float>(nebula.height/8)};
    Vector2 nebulaPos{windowWidth+20, windowHeight-nebulaRec.height};
    int nebulaVec{-600};
    int nebulaFrame{0};

    // jump velocity (pixels per second)
    const int jumpVel{-600};

    while (!WindowShouldClose()) {
        // start
        BeginDrawing();
        ClearBackground(WHITE);

        // delta time (time since last frame)
        const float dt{GetFrameTime()};

        // update running time
        scarfyRunningTime += dt;
        nebulaRunningTime += dt;

        if (scarfyPos.y >= windowHeight - scarfyRec.height)
        {
            scarfyVelocity = 0;
            isInAir = false;
        }
        else
        {
            scarfyVelocity += gravity * dt;
            isInAir = true;
        }

        // check jump
        if (IsKeyPressed(KEY_SPACE) && !isInAir)
        {
            scarfyVelocity += jumpVel;
        }

        // update nebula position
        nebulaPos.x += nebulaVec * dt;
        if (nebulaPos.x <= 0)
        {
            nebulaPos.x = windowWidth;
        }

        // update scarfy position
        scarfyPos.y += scarfyVelocity * dt;

        // update scarfy animation sprite
        if (!isInAir)
        {
            if (scarfyRunningTime >= scarfyUpdateTime) 
            {
                scarfyRec.x += scarfyRec.width;
                scarfyRunningTime = 0.0;
            }
        }

        // update nebula animation sprite
        if (nebulaRunningTime >= nebulaUpdateTime)
        {
            nebulaRunningTime = 0.0;
            nebulaRec.x = nebulaFrame * nebulaRec.width;

            nebulaFrame++;
            if (nebulaFrame > 7) {
                nebulaFrame = 0;
            }
        }

        // draw nebula
        DrawTextureRec(nebula, nebulaRec, nebulaPos, WHITE);

        // draw scarfy
        DrawTextureRec(scarfy, scarfyRec, scarfyPos, WHITE);

        // end
        EndDrawing();
    }

    UnloadTexture(scarfy);
    UnloadTexture(nebula);
    CloseWindow();
}