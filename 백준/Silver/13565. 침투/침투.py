from collections import deque
def bfs(x, y):
    q = deque()
    q.append((x, y))
    graph[x][y] = 2
    while q:
        x, y = q.popleft()    
        for dx, dy in d:
            X, Y = x+dx, y+dy
            if (0 <= X < M) and (0 <= Y < N) and graph[X][Y] == 0:
                q.append((X,Y))
                graph[X][Y] = 2
            
M, N = map(int, input().split())
graph = [list(map(int, list(input()))) for _ in range(M)]
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
for j in range(N):
    if graph[0][j] == 0:
        bfs(0, j)

print("YES" if 2 in graph[-1] else "NO")