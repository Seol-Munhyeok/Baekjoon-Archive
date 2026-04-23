import sys


n, m = map(int, sys.stdin.readline().split())
string_set = set()

for _ in range(n):
    string_set.add(sys.stdin.readline())

cnt = 0
for _ in range(m):
    if sys.stdin.readline() in string_set:
        cnt += 1

print(cnt)
