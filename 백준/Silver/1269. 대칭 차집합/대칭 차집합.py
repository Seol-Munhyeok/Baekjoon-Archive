import sys

a, b = map(int, sys.stdin.readline().split())
set_a = set(map(int, sys.stdin.readline().split()))
set_b = set(map(int, sys.stdin.readline().split()))

sym_diff = (set_a - set_b).union(set_b - set_a)
print(len(sym_diff))
