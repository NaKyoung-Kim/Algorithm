import sys
from collections import deque
input = sys.stdin.readline

def can_enter(level, name):
    for room in room_q:
        if len(room) < m and room[0][0]-10 <= level <= room[0][0]+10:
            room.append([level, name])
            return True
    return False

p, m = map(int, input().split())
player = deque()
for i in range(p):
    l, n = input().split()
    l = int(l)
    player.append([l,n])

room_q = deque([])

for i in range(p):
    level, name = player.popleft()
    if not can_enter(level, name):
        room_q.append([[level, name]])

for room in room_q:
    sort_room = deque((sorted(room, key = lambda x: x[1])))
    if len(sort_room) == m:
        print("Started!")
    else:
        print("Waiting!")
    for el in sort_room:
        print(el[0], el[1])