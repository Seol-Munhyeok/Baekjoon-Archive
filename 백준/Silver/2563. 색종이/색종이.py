import sys


def stick_papers(x, y):
    """ 배열에서 가로로 10, 세로로 10까지의 값을 1로 변경한다. """
    for i in range(10):
        for j in range(10):
            field[99-y-i][x+j] = 1


field = [[0] * 100 for _ in range(100)]
num = int(sys.stdin.readline())
for _ in range(num):
    a, b = map(int, sys.stdin.readline().split())
    stick_papers(a, b)

tmp, res = 0, 0
for i in range(100):
    tmp = field[i].count(1)
    res += tmp
print(res)
