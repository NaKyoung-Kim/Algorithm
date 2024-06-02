from collections import deque

R, C, N = map(int, input().split())
table = []
q = deque()

for i in range(R):
    temp = input()
    table.append(temp)
    for j in range(C):
        if temp[j] == 'O':
            q.append([i,j])

def explode(Q, table):
    while Q:
        x, y = Q.popleft()
        table[x][y] = '.'
        for dx, dy in (-1,0), (1,0), (0,-1), (0, 1):
            nx, ny = x+dx, y+dy
            if 0 <= nx < R and 0 <= ny < C and table[nx][ny] == 'O':
                table[nx][ny] = '.'

for time in range(1, N+1):
    if time == 1:
        continue
    elif time != 1 and time % 2 == 1:
        explode(q, table)
        for i in range(R):
            for j in range(C):
                if table[i][j] == 'O':
                    q.append([i,j])
    else:
        table = [['O']*C for _ in range(R)]

for i in range(R):
    for j in table[i]:
        print(j,end='')
    print()