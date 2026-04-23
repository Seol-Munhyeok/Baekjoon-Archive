import math


def count_room(address):
    """
    방의 주소 address가 주어질 때 최소의 방의 개수 n을 구하는 함수이다.

    이를 구하기 위해 먼저
    방의 개수 n이 주어질 때 그 방의 최대 주소값을 구하는 일반항
    f(n) = 3n^2 - 3n + 1
     을 앞서 구하였다.

     이를 이용하여 f(n) = 3n^2 - 3n + 1 >= address를 만족하는
     n의 최솟값을 구하면 된다.

     n^2 - n >= (address - 1) / 3
     이고 n>=0 이므로

     n^2 >= n^2 - n >= (address - 1) / 3
     n >= sqrt((address - 1) / 3)

     여기서 n은 정수이므로 반올림한다.
     또 처음 벌집도 세어줘야하므로 1을 더한다.
    """

    return round(math.sqrt((address - 1) / 3)) + 1


address = int(input())
print(count_room(address))

# 질문 게시판의 내용을 참고하였음
