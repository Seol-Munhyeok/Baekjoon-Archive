import sys

lst = []
n, m = map(int, sys.stdin.readline().split())
for a in range(n):
    lst.append(0)

for b in range(m):
    i, j, k = map(int, sys.stdin.readline().split())
    for c in range(i-1, j):
        lst[c] = k

print(" ".join(map(str, lst)))