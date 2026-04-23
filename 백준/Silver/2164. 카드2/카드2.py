import sys
from collections import deque

n = int(sys.stdin.readline())
q = deque(num for num in range(1, n+1))

while len(q) > 1:
    q.popleft()
    q.rotate(-1)

print(*q)
