import sys
white = 0
blue = 0

def check(x, y, N):
    global white, blue
    col = paper[x][y]
    for i in range(N):
        for j in range(N):
            if paper[x+i][y+j] != col:
                check(x, y, N//2)
                check(x+N//2, y, N//2)
                check(x, y+N//2, N//2)
                check(x+N//2, y+N//2, N//2)
                return
    if col == 0:
        white += 1
    else:
        blue += 1

N = int(sys.stdin.readline())
paper = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
check(0, 0, N)

print(white)
print(blue)