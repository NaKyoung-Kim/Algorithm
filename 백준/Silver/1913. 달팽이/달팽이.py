N = int(input())
target = int(input())
table = [[0]*N for _ in range(N)]

cnt = 1
dxs = [-1, 0, 1, 0]
dys = [0, 1, 0, -1]

x = int((N-1)/2)
y = int((N-1)/2)

move = 0
i = 1
target_x = 0
target_y = 0

def getNextMove(move):
    if move == 3:
        move = -1
    return move+1

while i < N**2:
    for _ in range(cnt):
        if i == target:
            target_x, target_y = x, y

        if i > N**2:
            break
        table[x][y] = i
        if i!= 1 and _ == (cnt-1):
            move = getNextMove(move)
            if move == 0 or move == 2:
                cnt += 1
        x += dxs[move]
        y += dys[move]
        i += 1

for num_list in table:
    for c in num_list:
        print(c, end=" ")
    print()
print(target_x+1, target_y+1)