import sys

n, m = map(int, sys.stdin.readline().split())
lst = []


def foo(arr, x, y):
    new_lst = list(reversed(arr[x-1:y]))
    res = arr[:x-1] + new_lst + arr[y:]
    return res


for a in range(1, n+1):
    lst.append(a)

for b in range(m):
    i, j = map(int, sys.stdin.readline().split())
    lst = foo(lst, i, j)

print(*lst)

