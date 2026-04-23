import sys


def is_vps(string):
    stack = []
    for letter in string:
        if letter == '(':
            stack.append(letter)
        else:
            if not stack:
                return 'NO'
            else:
                stack.pop()
    if stack:
        return 'NO'
    else:
        return 'YES'


t = int(sys.stdin.readline())
for _ in range(t):
    string = sys.stdin.readline().rstrip()
    print(is_vps(string))
