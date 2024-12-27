use std::collections::VecDeque;

use bevy::prelude::*;
use pathfinding::prelude::astar;

use super::event::{RobotMoveEvent, RobotDisplayEvent};

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

#[derive(Component)]
pub struct Robot {
    first: usize,
    last: usize,
    is_moving: bool,
    path: VecDeque<(i32, i32)>,
}

pub fn animate_robot(
    mut ev_robot_move: EventReader<RobotMoveEvent>,
    mut query: Query<(&mut Robot, &mut Sprite, &mut Transform)>,
) {
    for (mut robot, mut sprite, mut transform) in &mut query {
        if let Some(atlas) = &mut sprite.texture_atlas {
            if robot.is_moving && !robot.path.is_empty() {
                let next_grid = robot.path.pop_front().unwrap();
                transform.translation.x = next_grid.0 as f32;
                transform.translation.y = next_grid.1 as f32;

                atlas.index = if atlas.index == robot.last {
                    robot.first
                } else {
                    atlas.index + 1
                };
            } else if robot.is_moving && robot.path.is_empty() {
                robot.is_moving = false;
                atlas.index = 0
            } else if !robot.is_moving && ev_robot_move.read().len() > 0 {
                let event = ev_robot_move.read().last();
                info!("[ROBOT | animate_robot] last event = {:?}", event);

                robot.is_moving = true;
                let path = find_path(
                    (
                        transform.translation.x as i32,
                        transform.translation.y as i32,
                    ),
                    (300, 300),
                )
                .unwrap()
                .0;
                robot.path = VecDeque::from(path);
                info!("[ROBOT | animate_robot] path = {:?}", robot.path);
            };
        };
    }
}

pub fn update_robot_status(
    mut text_query: Query<&mut Text2d>,
    mut ev_robot_move: EventReader<RobotDisplayEvent>,
) {
    for mut text in &mut text_query {
        if ev_robot_move.read().len() > 0 {
            if let Some(event) = ev_robot_move.read().last() {
                info!("[ROBOT | update_robot_status] last event = {:?}", event);
                text.0 = event.command.clone()
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
    //commands.spawn(Sprite::from_image(asset_server.load("grassground.png")));

    let robot_texture = asset_server.load("robots.png");
    let layout = TextureAtlasLayout::from_grid(UVec2::splat(24), 8, 1, None, None);
    let texture_atlas_layout = texture_atlas_layout.add(layout);
    let animation_indices = Robot {
        first: 0,
        last: 7,
        is_moving: false,
        path: VecDeque::new(),
    };

    commands
        .spawn((
            Sprite::from_atlas_image(
                robot_texture,
                TextureAtlas {
                    layout: texture_atlas_layout,
                    index: animation_indices.first,
                },
            ),
            Transform::from_xyz(50., 0., 0.).with_scale(Vec3::splat(3.0)),
            animation_indices,
        ))
        .with_children(|parent| {
            parent.spawn((
                Text2d::new("IDLE"),
                Transform::from_xyz(0., 15., 0.),
                TextColor(Color::WHITE),
                TextFont {
                    font_size: 5.0,
                    ..default()
                },
            ));
        });
}
