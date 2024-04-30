import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    stock_price = list(map(int, input().split()))
    stock_num = 0
    profit = 0
    max_price = 0

    for i in range(N-1, -1, -1):
        if max_price < stock_price[i]:
            max_price = stock_price[i]
        else:
            profit += max_price-stock_price[i]
    print(profit)