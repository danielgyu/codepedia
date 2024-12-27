use bevy::prelude::*;

use super::event::RobotMoveEvent;

pub fn send_robot_move_event(
    keys: Res<ButtonInput<KeyCode>>,
    mut ev_command_robot_move: EventWriter<RobotMoveEvent>,
) {
    if keys.just_pressed(KeyCode::Digit5) {
        info!("[TESTER] sent robot move event");
        ev_command_robot_move.send(RobotMoveEvent);
    }
}
