use bevy::prelude::*;

#[derive(Debug, Event)]
pub struct RobotMoveEvent {
    pub command: String,
    pub destination: String,
}

#[derive(Debug, Event)]
pub struct RobotDisplayEvent {
    pub command: String,
    pub destination: String,
}
