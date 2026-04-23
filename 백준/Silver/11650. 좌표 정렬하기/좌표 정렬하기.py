import sys

n = int(sys.stdin.readline())
lst = []

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    lst.append((a, b))

lst.sort()

for item in lst:
    print(item[0], item[1])
