# 메모리: 34096 KB, 시간: 64 ms

from collections import deque

def isExist(x, y, N):
    return 0 <= x < N and 0 <= y < N

def bfs(i, j):
    queue = deque()
    queue.append([i,j])
    house_in_complex = 0
    while queue:
        x, y = queue.popleft()
        if house[x][y] == 1:
            house[x][y] = 0
            house_in_complex += 1
        for dx, dy in (0,-1), (0,1), (-1,0), (1,0):
            if isExist(x+dx, y+dy, N) and house[x+dx][y+dy] == 1:
                house[x+dx][y+dy] = 0
                queue.append([x+dx,y+dy])
                house_in_complex += 1
    return house_in_complex

N = int(input())
house = list()
num_of_house = list()

for _ in range(N):
    temp_house = list(map(int, input()))
    house.append(temp_house)

for i in range(N):
    for j in range(N):
        if house[i][j] == 1:
            num_of_house.append(bfs(i,j))

print(len(num_of_house))
for n in sorted(num_of_house):
    print(n)
