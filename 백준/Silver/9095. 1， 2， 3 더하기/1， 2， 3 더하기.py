import sys

def dp(n):
    if n == 1:
        return 1
    elif n == 2:
        return dp(n-1)+1
    elif n == 3:
        return dp(n-1)+dp(n-2)+1
    else:
        return dp(n-3) + dp(n-2) +dp(n-1)

input = sys.stdin.readline
T = int(input())

for _ in range(T):
    n = int(input())
    print(dp(n))