use rand::{thread_rng, Rng};

use bevy::prelude::*;

use super::event::*;
use super::warehouse::WarehouseLocationMap;

pub fn trigger_send_robot_move_event(
    keys: Res<ButtonInput<KeyCode>>,
    warehouse_location_map: ResMut<WarehouseLocationMap>,
    ev_command_robot_move: EventWriter<RobotMoveEvent>,
    ev_display_robot_move: EventWriter<RobotDisplayEvent>,
) {
    if keys.just_pressed(KeyCode::Digit5) {
        send_robot_move_event(
            warehouse_location_map,
            ev_command_robot_move,
            ev_display_robot_move,
        );
    }
}

pub fn send_robot_move_event(
    mut warehouse_location_map: ResMut<WarehouseLocationMap>,
    mut ev_command_robot_move: EventWriter<RobotMoveEvent>,
    mut ev_display_robot_move: EventWriter<RobotDisplayEvent>,
) {
    let mut rng = thread_rng();

    let suffix = rng.gen_range(1..30);
    let destination = format!("A-01-{}", suffix);

    let location: (i32, i32) = match warehouse_location_map
        .coordinate_by_location
        .get(&destination)
    {
        Some(coordinate) => *coordinate,
        None => {
            let x: i32 = rng.gen_range(0..300);
            let y: i32 = rng.gen_range(0..300);
            (x, y)
        }
    };
    warehouse_location_map
        .coordinate_by_location
        .insert(destination.clone(), location);

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

pub fn trigger_send_robot_move_event_after_arrived_event(
    warehouse_location_map: ResMut<WarehouseLocationMap>,
    ev_command_robot_move: EventWriter<RobotMoveEvent>,
    ev_display_robot_move: EventWriter<RobotDisplayEvent>,
    mut ev_receive_robot_arrived: EventReader<RobotArrivedEvent>,
) {
    if ev_receive_robot_arrived.read().len() > 0 {
        info!("[TESTER] received robot arrived event");
        send_robot_move_event(
            warehouse_location_map,
            ev_command_robot_move,
            ev_display_robot_move,
        );
    };
}
