import sys


factor_lst = []
n, k = map(int, sys.stdin.readline().split())

for i in range(1, n+1):
    if n % i == 0:
        factor_lst.append(i)

try:
    print(factor_lst[k-1])
except IndexError:
    print(0)
    