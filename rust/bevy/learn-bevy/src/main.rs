use bevy::prelude::*;

pub mod plugins;
pub mod setup;

fn main() {
    App::new()
        .add_plugins(DefaultPlugins)
        .add_systems(Startup, setup::initial_setup)
        .add_systems(Update, setup::kundoong_keyboard_movement)
        .run();
}
