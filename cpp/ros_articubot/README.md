[Basic world & robot]
- run `./run.sh` from root directory


[Description]
- uses rviz2 & gazebo for visualization
- additional plugins
  - rviz: `rviz2-d ./dev_ws/src/config/main.rviz`
  - SLAM: `ros2 launch slam_toolbox online_async_launch.py params_file:=./dev_ws/src/config/mapper_params_online_async.yaml  use_sim_time:=true`
