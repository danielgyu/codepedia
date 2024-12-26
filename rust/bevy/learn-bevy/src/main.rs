use bevy::prelude::*;

pub mod plugins;
pub mod robot;

fn main() {
    App::new()
        .add_plugins(DefaultPlugins.set(ImagePlugin::default_nearest())) // prevents blurry sprites
        .add_systems(Startup, robot::setup)
        .add_systems(Update, robot::animate_robot)
        .run();
}
