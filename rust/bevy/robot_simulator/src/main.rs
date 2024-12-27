use bevy::prelude::*;

pub mod event;
pub mod robot;
pub mod tester;

fn main() {
    App::new()
        .add_plugins(DefaultPlugins)
        .add_systems(Startup, robot::setup)
        .add_systems(Update, robot::animate_robot)
        .add_systems(Update, robot::update_robot_status)
        .add_systems(Update, tester::send_robot_move_event)
        .add_event::<event::RobotMoveEvent>()
        .run();
}
