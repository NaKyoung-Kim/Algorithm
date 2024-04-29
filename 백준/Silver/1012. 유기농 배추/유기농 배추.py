import sys

def canGo(i,j):
    return 0 <= i < M and 0 <= j < N

def dfs(i, j):
    stack = [(i,j)]
    while stack:
        x,y = stack.pop()
        if ground[x][y] == 1:
            ground[x][y] = 0
            for dx, dy in [(1,0), (-1,0), (0,1), (0,-1)]:
                nx, ny = x+dx, y+dy
                if canGo(nx, ny) and ground[nx][ny] == 1:
                    stack.append((nx,ny))

input = sys.stdin.readline
T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    ground = [[0]*N for _ in range(M)]
    count = 0
    for _ in range(K):
        x, y = map(int, input().split())
        ground[x][y] = 1

    for i in range(M):
        for j in range(N):
            if ground[i][j] == 1:
                count += 1
                dfs(i, j)
    print(count)