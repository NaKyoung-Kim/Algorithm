n = int(input())
d = []
for i in range(n):
  d.append(list(map(int, input().split())))
d.sort()
d.sort(key = lambda x:x[1])
count = 0
end = 0
for i in range(n):
  if d[i][0] >= end and end <= d[i][1] :
    count += 1
    end = d[i][1]

print(count)