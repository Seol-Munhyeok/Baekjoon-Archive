import sys


def classify_triangle(x, y, z):
    max_edge = max(x, y, z)
    sum_edge = x + y + z
    if max_edge >= sum_edge - max_edge:
        print('Invalid')
    else:
        if x == y == z:
            print('Equilateral')
        elif x == y or y == z or x == z:
            print('Isosceles')
        else:
            print('Scalene')


while True:
    a, b, c = map(int, sys.stdin.readline().split())
    if (a, b, c) == (0, 0, 0):
        break
    classify_triangle(a, b, c)
    