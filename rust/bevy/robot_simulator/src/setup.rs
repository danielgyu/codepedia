use std::time::Duration;

use bevy::prelude::*;

#[derive(Component)]
pub struct Robot;

#[derive(Component)]
pub struct AnimationConfig {
    first_sprite_index: usize,
    last_sprite_index: usize,
    fps: u8,
    frame_timer: Timer,
}

impl AnimationConfig {
    fn new(first: usize, last: usize, fps: u8) -> Self {
        Self {
            first_sprite_index: first,
            last_sprite_index: last,
            fps,
            frame_timer: Self::timer_from_fps(fps),
        }
    }

    fn timer_from_fps(fps: u8) -> Timer {
        Timer::new(Duration::from_secs_f32(1.0 / (fps as f32)), TimerMode::Once)
    }
}

pub fn execute_animations(mut query: Query<(&mut AnimationConfig, &mut Sprite)>) {
    for (config, mut sprite) in &mut query {
        if let Some(atlas) = &mut sprite.texture_atlas {
            if atlas.index == config.last_sprite_index {
                atlas.index = config.first_sprite_index;
            } else {
                atlas.index += 1;
            }
        }
    }
}


pub fn initial_setup(
    mut commands: Commands,
    asset_server: Res<AssetServer>,
    mut texture_atlas_layouts: ResMut<Assets<TextureAtlasLayout>>,
) {
    commands.spawn(Camera2d);

    let robot = asset_server.load("robots.png");

    let layout = TextureAtlasLayout::from_grid(UVec2::splat(30), 8, 1, None, None);
    let texture_atlas_layout = texture_atlas_layouts.add(layout);
    let animation_config = AnimationConfig::new(1, 7, 10);

    commands.spawn((
        Sprite {
            image: robot.clone(),
            texture_atlas: Some(TextureAtlas {
                layout: texture_atlas_layout.clone(),
                index: 0,
            }),
            ..Default::default()
        },
        Transform::from_scale(Vec3::splat(6.0)).with_translation(Vec3::new(25.0, 0.0, 0.0)),
        Robot,
        animation_config,
    ));
}
