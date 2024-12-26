use bevy::prelude::*;
use pathfinding::prelude::astar;

fn find_path(start: (i32, i32), goal: (i32, i32)) -> Option<(Vec<(i32, i32)>, u32)> {
    astar(
        &start,
        |&(x, y)| {
            vec![(x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)]
                .into_iter()
                .map(|p| (p, 1))
        },
        |&(x, y)| (goal.0.abs_diff(x) + goal.1.abs_diff(y)),
        |&p| p == goal,
    )
}

fn move_robot(keys: &Res<ButtonInput<KeyCode>>, mut transform: Mut<Transform>) {
    if keys.pressed(KeyCode::KeyW) {
        transform.translation.y += 5.0
    }
    if keys.pressed(KeyCode::KeyS) {
        transform.translation.y -= 5.0
    }
    if keys.pressed(KeyCode::KeyA) {
        transform.translation.x -= 5.0
    }
    if keys.pressed(KeyCode::KeyD) {
        transform.translation.x += 5.0
    }

    let start = (
        transform.translation.x as i32,
        transform.translation.y as i32,
    );
    let goal = (80, 80);
    let found = find_path(start, goal).unwrap().0;
    println!("found={:?}", found);

    println!(
        "robot at x={:?}, y={:?}",
        transform.translation.x, transform.translation.y
    );
}

#[derive(Component)]
pub struct RobotAnimationIndices {
    first: usize,
    last: usize,
    is_running: bool,
}

pub fn animate_robot(
    keys: Res<ButtonInput<KeyCode>>,
    mut query: Query<(&RobotAnimationIndices, &mut Sprite, &mut Transform)>,
) {
    let movement_keys_pressed =
        keys.any_pressed([KeyCode::KeyA, KeyCode::KeyW, KeyCode::KeyD, KeyCode::KeyS]);

    for (indices, mut sprite, transform) in &mut query {
        if let Some(atlas) = &mut sprite.texture_atlas {
            if movement_keys_pressed {
                atlas.index = if atlas.index == indices.last {
                    indices.first
                } else {
                    atlas.index + 1
                };

                move_robot(&keys, transform);
            } else {
                atlas.index = 0
            };
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
    let animation_indices = RobotAnimationIndices {
        first: 0,
        last: 7,
        is_running: false,
    };

    commands.spawn((
        Sprite::from_atlas_image(
            robot_texture,
            TextureAtlas {
                layout: texture_atlas_layout,
                index: animation_indices.first,
            },
        ),
        Transform::from_xyz(50., 0., 0.).with_scale(Vec3::splat(4.0)),
        animation_indices,
    ));
}
