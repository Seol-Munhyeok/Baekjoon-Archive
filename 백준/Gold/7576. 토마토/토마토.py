from collections import deque
import sys

m, n = map(int, input().split())
arr = []
ones = []

# 입력 처리, 1인 좌표 저장
for i in range(n):
    row = []
    for j, val in enumerate(map(int, input().split())):
        row.append(val)
        if val == 1:
            ones.append((i, j))
    arr.append(row)

# 모든 1에 대해 단계 별로 BFS
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]
queue = deque()
for one in ones:
    queue.append(one)

answer = 0
while queue:
    # 토마토가 모두 익었는지 체크
    finished = True
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 0:
                finished = False
                break
        if not finished:
            break
    
    if finished:
        print(answer)
        sys.exit()

    # 안 익은 토마토가 있으면 탐색 시작
    size = len(queue)
    answer += 1
    for _ in range(size):
        y, x = queue.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and arr[ny][nx] == 0:
                arr[ny][nx] = 1
                queue.append((ny, nx))

# 불가능인 경우
print(-1)