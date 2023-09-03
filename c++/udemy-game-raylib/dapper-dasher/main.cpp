#include <stdio.h>
#include "raylib.h"

struct AnimData
{
    Rectangle rec;
    Vector2 pos;
    int frame;
    float updateTime;
    float runningTime;
};

bool isOnGround(AnimData data, int windowHeight)
{
    return data.pos.y >= windowHeight - data.rec.height;
}

AnimData updateAnimation(AnimData animData, float dt, int maxFrame)
{
    animData.runningTime += dt;
    if (animData.runningTime >= animData.updateTime) 
    {
        animData.runningTime = 0.0;
        animData.rec.x += animData.rec.width;
        animData.frame++;
        if (animData.frame > maxFrame)
        {
            animData.frame = 0;
        }
    }
    return animData;
}

int main()
{
    int windowDimensions[2] = {512, 380};
    InitWindow(windowDimensions[0], windowDimensions[1], "Dapper Dasher");
    SetTargetFPS(60);

    bool collision{false};

    const int sizeOfNebulae{1};

    bool isInAir{};

    // acceleration due to gravity (pixels/s)/s
    const int gravity{1'000};

    // background
    Texture2D background = LoadTexture("textures/far-buildings.png");
    float bgX{};

    // midground
    Texture2D midground = LoadTexture("textures/back-buildings.png");
    float mgX{};

    //foreground
    Texture2D foreground = LoadTexture("textures/foreground.png");
    float fgX{};

    // scarfy
    Texture2D scarfy = LoadTexture("textures/scarfy.png");
    AnimData scarfyAnim{
        {0.0, 0.0, static_cast<float>(scarfy.width/6), static_cast<float>(scarfy.height)},
        {static_cast<float>(windowDimensions[0]/2 - scarfy.width/6/2), static_cast<float>(windowDimensions[1]-scarfy.height)},
        0,
        1.0/12.0,
        0.0
    };
    int scarfyVelocity{0};

    // nebula sprite
    Texture2D nebula = LoadTexture("textures/12_nebula_spritesheet.png");

    // nebula array
    Color nebulaColors[6]{RED, WHITE, BLUE, GRAY, YELLOW, BROWN};
    int nebulaVecs[6]{-300, -1000, -400, -500, -500, -500};
    int startingPosition[6]{100, 200, 300, 400, 500, 600};

    AnimData nebulas[sizeOfNebulae];
    for (int i=0; i<sizeOfNebulae; i++)
    {
        nebulas[i] = {
            {0.0, 0.0, static_cast<float>(nebula.width/8), static_cast<float>(nebula.height/8)},
            {static_cast<float>(windowDimensions[0]+startingPosition[i]), static_cast<float>(windowDimensions[1]-nebula.height/8)},
            0,
            1.0/16.0,
            0.0
        };
    };

    // finish condition
    float runningTime{0.0};
    float finishTime{10.0};

    // jump velocity (pixels per second)
    const int jumpVel{-600};

    while (!WindowShouldClose()) {
        // start
        BeginDrawing();
        ClearBackground(WHITE);

        // delta time (time since last frame)
        const float dt{GetFrameTime()};

        // draw the scrolling background
        bgX -= 20 * dt;
        if (bgX <= -background.width*2)
        {
            bgX = 0.0;
        }

        // draw the scrolling midground
        mgX -= 40 * dt;
        if (mgX <= -background.width*2)
        {
            mgX = 0.0;
        }

        // draw the scrolling foreground
        fgX -= 80 * dt;
        if (fgX <= -background.width*2)
        {
            fgX = 0.0;
        }

        // background
        Vector2 bg1Pos = {bgX, 0.0};
        DrawTextureEx(background, bg1Pos, 0.0, 2.0, WHITE);
        Vector2 bg2Pos{bgX + background.width*2, 0.0}; // *2 to match scale
        DrawTextureEx(background, bg2Pos, 0.0, 2.0, WHITE);

        // midground
        Vector2 mg1Pos = {mgX, 0.0};
        DrawTextureEx(midground, mg1Pos, 0.0, 2.0, WHITE);
        Vector2 mg2Pos{mgX + midground.width*2, 0.0}; // *2 to match scale
        DrawTextureEx(midground, mg2Pos, 0.0, 2.0, WHITE);

        // foreground
        Vector2 fg1Pos = {fgX, 0.0};
        DrawTextureEx(foreground, fg1Pos, 0.0, 2.0, WHITE);
        Vector2 fg2Pos{fgX + foreground.width*2, 0.0}; // *2 to match scale
        DrawTextureEx(foreground, fg2Pos, 0.0, 2.0, WHITE);

        for (AnimData n : nebulas)
        {
            n.runningTime += dt;
        }

        if (isOnGround(scarfyAnim, windowDimensions[1]))
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

        // update nebula positions
        for (int i=0; i<sizeOfNebulae; i++)
        {
            nebulas[i].pos.x += nebulaVecs[i] * dt;
            if (nebulas[i].pos.x <= -30)
            {
                nebulas[i].pos.x = windowDimensions[0]+100;
            }
        }

        // update scarfy position
        scarfyAnim.pos.y += scarfyVelocity * dt;

        // update finish line
        runningTime += dt; 

        // update scarfy animation sprite
        if (!isInAir)
        {
            scarfyAnim = updateAnimation(scarfyAnim, dt, 5);
        }

        // update nebulas
        for (AnimData n : nebulas)
        {
            n = updateAnimation(n, dt, 7);
        }

        // check collision
        for (AnimData nebula : nebulas)
        {
            float pad{20};
            Rectangle nebulaCollisionRec{
                nebula.pos.x + pad,
                nebula.pos.y + pad,
                nebula.rec.width - 2*pad,
                nebula.rec.height - 2*pad
            };

            Rectangle scarfyCollisionRec{
                scarfyAnim.pos.x,
                scarfyAnim.pos.y,
                scarfyAnim.rec.width,
                scarfyAnim.rec.height
            };

            if (CheckCollisionRecs(nebulaCollisionRec, scarfyCollisionRec))
            {
                collision = true;
            }
        }

        if (collision && runningTime < finishTime)
        {
            DrawText("Game Over!", windowDimensions[0]/3, windowDimensions[1]/2, 40, RED);
        }
        else if (runningTime >= finishTime)
        {
            DrawText("You Win!", windowDimensions[0]/3, windowDimensions[1]/2, 40, WHITE);
        }
        else
        {
            // draw nebulas
            for (int i=0; i<sizeOfNebulae; i++)
            {
                DrawTextureRec(nebula, nebulas[i].rec, nebulas[i].pos, nebulaColors[i]);
            }

            // draw scarfy
            DrawTextureRec(scarfy, scarfyAnim.rec, scarfyAnim.pos, WHITE);
        }

        // end
        EndDrawing();
    }

    UnloadTexture(background);
    UnloadTexture(midground);
    UnloadTexture(foreground);
    UnloadTexture(scarfy);
    UnloadTexture(nebula);
    CloseWindow();
}