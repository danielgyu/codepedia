use bevy::prelude::*;

#[derive(Component)]
pub struct RobotAnimationIndices {
    first: usize,
    last: usize,
}

#[derive(Component, Deref, DerefMut)]
pub struct AnimationTimer(Timer);

pub fn animate_robot(
    time: Res<Time>,
    mut query: Query<(&RobotAnimationIndices, &mut AnimationTimer, &mut Sprite)>,
) {
    for (indices, mut timer, mut sprite) in &mut query {
        timer.tick(time.delta());

        if timer.just_finished() {
            if let Some(atlas) = &mut sprite.texture_atlas {
                atlas.index = if atlas.index == indices.last {
                    indices.first
                } else {
                    atlas.index + 1
                };
            }
        }
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
    let animation_indices = RobotAnimationIndices { first: 1, last: 7 };

    commands.spawn((
        Sprite::from_atlas_image(
            robot_texture,
            TextureAtlas {
                layout: texture_atlas_layout,
                index: animation_indices.first,
            },
        ),
        Transform::from_scale(Vec3::splat(6.0)),
        animation_indices,
        AnimationTimer(Timer::from_seconds(0.4, TimerMode::Repeating)),
    ));
}
