use bevy::prelude::*;

#[derive(Component)]
pub struct RobotAnimationIndices {
    first: usize,
    last: usize,
}

#[derive(Component, Deref, DerefMut)]
pub struct AnimationTimer(Timer);

pub fn animate_robot(
    keys: Res<ButtonInput<KeyCode>>,
    time: Res<Time>,
    mut query: Query<(
        &RobotAnimationIndices,
        &mut AnimationTimer,
        &mut Sprite,
        &mut Transform,
    )>,
) {
    let movement_keys_pressed =
        keys.any_pressed([KeyCode::KeyA, KeyCode::KeyW, KeyCode::KeyD, KeyCode::KeyS]);

    for (indices, mut timer, mut sprite, mut transform) in &mut query {
        timer.tick(time.delta());

        if timer.just_finished() {
            if let Some(atlas) = &mut sprite.texture_atlas {
                if movement_keys_pressed {
                    atlas.index = if atlas.index == indices.last {
                        indices.first
                    } else {
                        atlas.index + 1
                    };

                    let key = keys.get_just_pressed().last();
                    match key {
                        Some(k) => match k {
                            KeyCode::KeyA => transform.translation.x -= 10.0,
                            KeyCode::KeyD => transform.translation.x += 10.0,
                            KeyCode::KeyW => transform.translation.y += 10.0,
                            KeyCode::KeyS => transform.translation.y -= 10.0,
                            _ => (),
                        },
                        None => (),
                    }
                } else {
                    atlas.index = 0
                };
            };
            println!(
                "robot at x={:?}, y={:?}",
                transform.translation.x, transform.translation.y
            );
        };
    }
}

pub fn setup(
    mut commands: Commands,
    asset_server: Res<AssetServer>,
    mut texture_atlas_layout: ResMut<Assets<TextureAtlasLayout>>,
) {
    commands.spawn(Camera2d);
    commands.spawn(Sprite::from_image(asset_server.load("grassground.png")));

    let robot_texture = asset_server.load("robots.png");
    let layout = TextureAtlasLayout::from_grid(UVec2::splat(24), 8, 1, None, None);
    let texture_atlas_layout = texture_atlas_layout.add(layout);
    let animation_indices = RobotAnimationIndices { first: 0, last: 7 };

    commands.spawn((
        Sprite::from_atlas_image(
            robot_texture,
            TextureAtlas {
                layout: texture_atlas_layout,
                index: animation_indices.first,
            },
        ),
        //Transform::from_scale(Vec3::splat(3.0)),
        //Transform::from_xyz(50., 0., 0.),
        Transform::from_xyz(50., 0., 0.).with_scale(Vec3::splat(4.0)),
        animation_indices,
        AnimationTimer(Timer::from_seconds(0.1, TimerMode::Repeating)),
    ));
}
