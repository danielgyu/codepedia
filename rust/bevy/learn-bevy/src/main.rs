use bevy::prelude::*;

pub mod plugins;
pub mod setup_kundoong;

fn main() {
    App::new()
        .add_plugins(DefaultPlugins.set(ImagePlugin::default_nearest())) // prevents blurry sprites
        .add_systems(Startup, setup_kundoong::initial_setup)
        .add_systems(Update, setup_kundoong::kundoong_keyboard_movement)
        .run();
}
