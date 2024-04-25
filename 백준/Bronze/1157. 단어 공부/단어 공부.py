word = input()
char = {}

for c in word:
    c = c.upper()
    if c in char:
        char[c] += 1
    else:
        char[c] = 1
char = sorted(char.items(), reverse=True, key=lambda x:x[1])

if len(char) > 1 and char[0][1] == char[1][1]:
    print("?")
else:
    print(char[0][0])