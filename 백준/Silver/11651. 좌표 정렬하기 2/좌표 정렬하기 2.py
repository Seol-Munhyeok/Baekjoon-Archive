import sys

n = int(sys.stdin.readline())
lst = []
sorted_lst = []

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    lst.append((a, b))

sorted_lst = sorted(lst, key=lambda x: (x[1], x[0]))

for item in sorted_lst:
    print(item[0], item[1])
