use bevy::prelude::*;

pub mod event;
pub mod robot;
pub mod tester;
pub mod warehouse;

fn camera_setup(mut commands: Commands) {
    commands.spawn(Camera2d);
}

fn main() {
    App::new()
        .add_plugins(DefaultPlugins)
        .add_systems(Startup, camera_setup)

        .add_systems(Startup, warehouse::setup)

        .add_systems(Startup, robot::setup)
        .add_systems(Update, robot::animate_robot)
        .add_systems(Update, robot::update_robot_status)

        .add_systems(Update, tester::trigger_send_robot_move_event)
        .add_systems(Update, tester::trigger_send_robot_move_event_after_arrived_event)

        .add_event::<event::RobotMoveEvent>()
        .add_event::<event::RobotDisplayEvent>()
        .add_event::<event::RobotArrivedEvent>()

        .run();
}
