import sys


def find_relation(x, y):
    if x % y == 0 or y % x == 0:
        if x > y:
            return 'multiple'
        elif x < y:
            return 'factor'
    else:
        return 'neither'


while True:
    a, b = map(int, sys.stdin.readline().split())
    if (a, b) == (0, 0):
        break
    print(find_relation(a, b))
