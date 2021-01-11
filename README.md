# 사다리 게임 3단계 미션

## 요구사항 🚀
> 주어진 3단계 미션 힌트에 따라 철.저.히 TDD로 구현한다. 

## 객체 추출 힌트 💡 

### 사다리 한 Line 추상화
* 사다리 게임에서 한 Line을 LadderLine으로 이름을 붙이고 다음과 같이 구현 
* 사다리 Line의 두 점과 현재 위치를 Point로 추상화 

### Ladder Line의 두 점과 현재 위치를 Point로 추상화 
* LadderLine에서 위치와 각 정의 방향을 관리 

### 각 Point 좌/우 방향을 Direction으로 추상화 
* 각 Point의 좌/우 방향 정보를 가진다. 
* 현재 Point에서 다음 Point를 생성하는 역할 

# 기능 구현 목록 🎯
-[x] 사다리의 한 라인을 만드는 기능
-[x] 사다리의 라인들을 생성하는 기능
-[x] 사다리라인을 따라 결과위치를 추적하는 기능
-[x] 사다리의 높이를 입력받는 기능
-[x] 사다리의 높이가 최소 높이보다 작으면 예외를 발생시키는 기능
-[x] 참가자의 이름을 입력받는 기능 
-[ ] 참가자의 이름이 5글자를 넘으면 예외를 발생시키는 기능 
-[ ] 사다리를 만드는 기능 
-[ ] 사용자를 입력받는 기능 
-[ ] 실행 결과를 입력받는 기능 
-[ ] 특정 사용자의 결과를 확인하는 기능
