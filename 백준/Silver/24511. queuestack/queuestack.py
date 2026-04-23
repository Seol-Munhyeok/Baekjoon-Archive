import sys
from collections import deque


n = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
C = list(map(int, sys.stdin.readline().split()))

q = deque([])
for i in range(n):
    if A[i] == 0:    # 스택일 때는 삽입된 원소가 바로 pop되므로 고려하지 않는다.
        q.append(B[i])
else:
    if not B:    # 모든 자료구조가 스택일 경우
        print(*C)
        sys.exit()

for i in range(m):    # 큐만 모아서 하나의 큐로 생각
    q.appendleft(C[i])    
    print(q.pop(), end=' ')
