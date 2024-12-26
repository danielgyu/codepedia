use bevy::prelude::*;

pub mod plugins;
//pub mod setup_kundoong;
pub mod setup_robot;

fn main() {
    App::new()
        //.add_plugins(DefaultPlugins)
        //.add_systems(Startup, setup_kundoong::initial_setup)
        //.add_systems(Update, setup_kundoong::kundoong_keyboard_movement)
        //
        .add_plugins(DefaultPlugins.set(ImagePlugin::default_nearest())) // prevents blurry sprites
        .add_systems(Startup, setup_robot::setup)
        .add_systems(Update, setup_robot::animate_robot)
        .run();
}
