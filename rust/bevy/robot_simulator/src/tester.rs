use rand::{thread_rng, Rng};

use bevy::prelude::*;

use super::event::{RobotMoveEvent, RobotDisplayEvent};
use super::warehouse::WarehouseLocationMap;

pub fn send_robot_move_event(
    keys: Res<ButtonInput<KeyCode>>,
    warehouse_location_map: Res<WarehouseLocationMap>,
    mut ev_command_robot_move: EventWriter<RobotMoveEvent>,
    mut ev_display_robot_move: EventWriter<RobotDisplayEvent>,
) {
    if keys.just_pressed(KeyCode::Digit5) {
        let mut rng = thread_rng();

        let suffix = rng.gen_range(1..30);
        let destination = format!("A-01-{}", suffix);
        
        let location: (i32, i32) = match warehouse_location_map.coordinate_by_location.get(&destination) {
            Some(coordinate) => coordinate.clone(),
            None => {
                let x: i32 = rng.gen_range(0..300);
                let y: i32 = rng.gen_range(0..300);
                (x, y)
            },
        };

        ev_command_robot_move.send(RobotMoveEvent {
            command: "MOVING".to_string(),
            destination: destination.clone(),
            location,
        });
        ev_display_robot_move.send(RobotDisplayEvent {
            command: "MOVING".to_string(),
            destination: destination.clone(),
        });

        info!("[TESTER] sent robot move event");
    }

}
