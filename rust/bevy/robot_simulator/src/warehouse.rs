use bevy::{prelude::*, utils::HashMap};

#[derive(Resource)]
pub struct WarehouseLocationMap {
    pub coordinate_by_location: HashMap<String, (i32, i32)>
}

pub fn setup(
    mut commands: Commands,
    asset_server: Res<AssetServer>,
) {
    commands.spawn((
        Sprite::from_image(asset_server.load("warehouse.png")),
        Transform::from_xyz(0.,0.,0.).with_scale(Vec3::splat(2.0)),
    ));
    commands.insert_resource(
        WarehouseLocationMap {
            coordinate_by_location: HashMap::new(),
        }
    )
}
