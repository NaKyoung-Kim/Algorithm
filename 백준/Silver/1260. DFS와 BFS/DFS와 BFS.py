import sys
from collections import deque

def dfs(V, visited, graph): # 깊이우선
    visited.append(V)
    print(V, end=" ")
    if V in graph:
        for node in graph[V]:
            if node not in visited:
                dfs(node, visited, graph)

def bfs(V, graph): # 너비우선
    visited = []
    queue = deque([V])

    while queue:
        node = queue.popleft()
        if node not in visited:
            visited.append(node)
            print(node, end=" ")
            if node in graph:
                for nextNode in graph[node]:
                    if nextNode not in visited:
                        queue.append(nextNode)

N, M, V = map(int, sys.stdin.readline().split())
graph = {}
for _ in range(M):
    node1, node2 = map(int, sys.stdin.readline().split())
    if node1 in graph:
        graph[node1].append(node2)
    else:
        graph[node1] = [node2]
    if node2 in graph:
        graph[node2].append(node1)
    else:
        graph[node2] = [node1]

for key in graph:
    graph[key] = sorted(graph[key])

visited_dfs = []
visited_bfs = []
stack = deque()

dfs(V, visited_dfs, graph)
print()
bfs(V, graph)