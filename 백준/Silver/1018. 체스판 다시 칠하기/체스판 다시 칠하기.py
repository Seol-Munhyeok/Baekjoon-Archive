import sys


def chess_board(corner):
    """
    :param corner: 맨 위쪽 끝 칸의 색 (1 = 흰색, -1 = 검은색)
    :return: 8 * 8 크기 체스판
    """
    n, m = 8, 8
    tmp_board = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if (i + j) % 2 == 0:
                tmp_board[i][j] = corner
            else:
                tmp_board[i][j] = corner * -1
    return tmp_board


def cut_board(my_board):
    """
    :param my_board: 8 * 8 크기로 자르기 전의 보드
    :return: 자를 수 있는 모든 경우의 8 * 8 크기의 보드
    """
    rows = len(my_board)
    cols = len(my_board[0])
    sub_board = []

    for i in range(rows - 8 + 1):
        for j in range(cols - 8 + 1):
            tmp_board = [
                my_board[i + r][j:j + 8]
                for r in range(8)
            ]
            sub_board.append(tmp_board)

    return sub_board


def compare_two_boards(my_board):
    """
    :param my_board: 8 * 8 형태로 분할된 비교할 보드
    :return: 다시 칠해야 하는 칸의 개수
    (보드와 체스판의 색을 비교 후, 서로 다른 것의 개수)
    """
    tmp, tmp2 = 0, 0
    for i in range(8):
        for j in range(8):
            tmp += abs(my_board[i][j] - chess_board_A[i][j])
            tmp2 += abs(my_board[i][j] - chess_board_B[i][j])
    return min(tmp//2, tmp2//2)


n, m = map(int, sys.stdin.readline().split())
board = [[0] * m for _ in range(n)]
chess_board_A = chess_board(1)    # 맨 위쪽 끝 칸이 흰색인 체스판
chess_board_B = chess_board(-1)    # 맨 위쪽 끝 칸이 검은색인 체스판

# 한 줄씩 문자열 입력을 받아서 W면 1을 B면 -1을 board에 할당합니다.
for row in range(n):
    board_row = sys.stdin.readline().strip()
    for col in range(m):
        if board_row[col] == 'W':
            board[row][col] = 1
        elif board_row[col] == 'B':
            board[row][col] = -1

res_lst = []
sub_boards = cut_board(board)
cnt = len(sub_boards)

# 입력으로 받은 board를 8 * 8 크기로 자를 수 있는 모든 보드에 대해서
# 다시 칠해야하는 칸의 개수를 배열에 넣습니다.
for i in range(cnt):
    res_lst.append(compare_two_boards(sub_boards[i]))

print(min(res_lst))
