import sys

lst = []
n, m = map(int, sys.stdin.readline().split())

for a in range(1, n+1):
    lst.append(a)

for b in range(m):
    i, j = map(int, sys.stdin.readline().split())
    lst[i-1], lst[j-1] = lst[j-1], lst[i-1]

print(" ".join(map(str, lst)))