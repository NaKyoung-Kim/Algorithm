def solution(s):
    answer = True
    flag = 0
    for c in s:
        if flag < 0:
            answer = False
            break
        if c == '(':
            flag += 1
        else:
            flag -= 1
    if flag != 0:
        answer = False
    
    return answer