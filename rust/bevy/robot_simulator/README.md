# Virtual Warehouse Robot Simulator

## 용도
- 가상의 물류센터의 로봇의 움직임을 시각화 & 시뮬레이션하기 위한 툴

## 실행법
- rust & cargo 설치
- `cargo run`
- 앱이 실행된 후, 숫자 '5'를 눌러서 로봇 이동

## 시뮬레이션 설명
- Rust의 게임엔진 `bevy`를 사용한 시뮬레이션
  - Bevy는 ECS(Entity Component System) 기반의 엔진
- 숫자5를 누르면 랜덤의 목표지점을 생성, 로봇이동 이벤트(event)를 발생
- 로봇이동 이벤트를 처리하는 시스템(system)은 astar 알고리즘을 활용하여 경로(Component)를 생성
  - astar 사용이유: 로봇은 좌우로 움직일 수 있기 때문에
- 경로가 생성된 로봇(Entity)은 매 프레임마다 다음 경로로 이동
- 목적지에 도착할 경우 도착 이벤트(event)를 발생
- 목적지 도착 이벤트를 처리하는 시스템은 바로 새로운 로봇 이동 이벤트를 발생

## 추가
- 로봇 위에 표시되는 글자는 현재 로봇의 상태(IDLE, MOVING, ARRIVED)
- Bevy 공식문서: https://bevyengine.org/
- Bevy 관련 개인 스터디 로그: https://www.notion.so/hismayfly/Bevy-Entities-Components-16a771321bca80cdb8ece81276619a42?pvs=4
