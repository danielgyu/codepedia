use bevy::prelude::*;

pub mod robot;

fn main() {
    App::new()
        .add_plugins(DefaultPlugins)
        .add_systems(Startup, robot::setup)
        .add_systems(Update, robot::animate_robot)
        .add_systems(Update, robot::update_robot_status)
        .run();
}
