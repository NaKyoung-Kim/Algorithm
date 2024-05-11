import sys
input = sys.stdin.readline

N = int(input())

table = []
profit = [0 for _ in range(N+1)]
for _ in range(N):
    table.append(list(map(int, input().split())))

for i in range(N):
    for j in range(i+table[i][0], N+1):
        if profit[j] < profit[i] + table[i][1]:
            profit[j] = profit[i] + table[i][1]

print(profit[N])