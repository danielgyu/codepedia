use bevy::prelude::*;

#[derive(Debug, Event)]
pub struct RobotMoveEvent {
    pub command: String,
    pub destination: String,
    pub location: (i32, i32),
}

#[derive(Debug, Event)]
pub struct RobotDisplayEvent {
    pub command: String,
    pub destination: String,
}
