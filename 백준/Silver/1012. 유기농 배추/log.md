## RecursionError
  `stack`을 사용하지 않고 `canGo()` 가 `true`를 반환하는 조건 하에 재귀함수를 사용했을 때 `RecursionError`가 발생했다.
  `stack`을 이용해 탐색할 배추의 위치를 기록하고, 해당 `stack`의 내용을 `pop` 하면서 `task`를 수행하도록 수정했다.


## dx, dy technique
  수정 전 버전에서는 `dx, dy 테크닉`을 쓰지 않고 하나하나 코드를 작성했었는데,

    for dx, dy in [(1,0), (-1,0), (0,1), (0,-1)]:
      nx, ny = x+dx, y+dy
      if canGo(nx, ny) and ground[nx][ny] == 1:
          stack.append((nx,ny))
          
  이런식으로 `dx, dy 테크닉`을 사용해 코드를 간결화할 수 있었다.
