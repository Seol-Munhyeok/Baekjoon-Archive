def solution(r, c, d, grid):
    dirs = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    answer = 0
    y, x, cur_dir = r, c, d
    while True:
        # 현재 칸이 아직 청소되지 않은 경우(0), 현재 칸을 청소(2)한다.
        if grid[y][x] == 0:
            grid[y][x] = 2
            answer += 1
        # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸(0)이 있는 경우
        if any(grid[y + dy][x + dx] == 0 for dy, dx in dirs):
            for _ in range(4):
                cur_dir = (cur_dir + 3) % 4  # 반시계 90도 회전
                dy, dx = dirs[cur_dir]
                ny, nx = y + dy, x + dx
                if grid[ny][nx] == 0:
                    y, x = ny, nx
                    break
        # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸(0)이 없는 경우,
        else:
            cur_dir = (cur_dir + 2) % 4  # 후진 방향
            dy, dx = dirs[cur_dir]
            ny, nx = y + dy, x + dx
            # 벽이 아니라서 후진할 수 있는 경우
            if grid[ny][nx] != 1:
                y, x = ny, nx
                cur_dir = (cur_dir + 2) % 4  # 방향은 다시 되돌림
            else:
                return answer


# 입력 처리
n, m = map(int, input().split())
r, c, d = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

print(solution(r, c, d, grid))
