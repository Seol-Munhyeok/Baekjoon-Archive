import math


def number_of_dots(n):
    # 초기 조건
    if n == 1:
        return 9

    # 재귀적 정의
    else:
        return math.pow(math.sqrt(number_of_dots(n-1)) * 2 - 1, 2)


tries = int(input())
print(int(number_of_dots(tries)))