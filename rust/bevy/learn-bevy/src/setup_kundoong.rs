use bevy::prelude::*;

#[derive(Component)]
pub struct Character;

pub fn kundoong_keyboard_movement(
    keys: Res<ButtonInput<KeyCode>>,
    mut query: Query<(&mut Character, &mut Transform)>,
) {
    if keys.pressed(KeyCode::KeyW) {
        for (_, mut transform) in &mut query {
            transform.translation.y += 5.0
        }
    }
    if keys.pressed(KeyCode::KeyS) {
        for (_, mut transform) in &mut query {
            transform.translation.y -= 5.0
        }
    }
    if keys.pressed(KeyCode::KeyA) {
        for (_, mut transform) in &mut query {
            transform.translation.x -= 5.0
        }
    }
    if keys.pressed(KeyCode::KeyD) {
        for (_, mut transform) in &mut query {
            transform.translation.x += 5.0
        }
    }
}

pub fn initial_setup(mut commands: Commands, asset_server: Res<AssetServer>) {
    let shire = Sprite::from_image(asset_server.load("shire.png"));

    let mut kundoong = Sprite::from_image(asset_server.load("kundoong.png"));
    kundoong.custom_size = Some(Vec2::new(100., 100.));

    commands.spawn(Camera2d);
    commands.spawn(shire);
    commands.spawn((Character, kundoong, Transform::from_xyz(50., 0., 0.)));
}
