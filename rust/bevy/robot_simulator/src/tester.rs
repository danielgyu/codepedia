use bevy::prelude::*;

use super::event::{RobotMoveEvent, RobotDisplayEvent};

pub fn send_robot_move_event(
    keys: Res<ButtonInput<KeyCode>>,
    mut ev_command_robot_move: EventWriter<RobotMoveEvent>,
    mut ev_display_robot_move: EventWriter<RobotDisplayEvent>,
) {
    if keys.just_pressed(KeyCode::Digit5) {
        ev_command_robot_move.send(RobotMoveEvent {
            command: "MOVING".to_string(),
            destination: "A-01-01".to_string(),
        });
        ev_display_robot_move.send(RobotDisplayEvent {
            command: "MOVING".to_string(),
            destination: "A-01-01".to_string(),
        });

        info!("[TESTER] sent robot move event");
    }

}
