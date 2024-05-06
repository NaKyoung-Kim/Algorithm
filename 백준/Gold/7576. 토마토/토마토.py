import sys
from collections import deque

def is_in_range(x, y):
    return 0 <= x < N and 0 <= y < M

def bfs():
    while queue:
        x, y = queue.popleft()
        for dx, dy in (0,1),(0,-1),(1,0),(-1,0):
            if is_in_range(x+dx, y+dy) and tomato[x+dx][y+dy] == 0:
                tomato[x+dx][y+dy] = tomato[x][y] + 1
                queue.append((x+dx, y+dy))

input = sys.stdin.readline
M, N = map(int, input().split())
tomato = list(list(map(int, input().split())) for _ in range(N))
queue = deque([(i,j) for i in range(N) for j in range(M) if tomato[i][j] == 1])

bfs()

max_day = max(max(row) for row in tomato)
if any(0 in row for row in tomato):
    print(-1)
elif max_day == 1:
    print(0)
else:
    print(max_day-1)