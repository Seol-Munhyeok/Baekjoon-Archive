import sys, math


def is_prime(number):
    # 2는 소수이므로 True 반환
    if number == 2:
        return True

    # 0, 1 또는 짝수인 경우 False 반환
    if number < 2 or number % 2 == 0:
        return False

    # 홀수만 검사함
    for i in range(3, math.isqrt(number) + 1, 2):
        if number % i == 0:
            return False
    return True


def next_prime(number):
    if number in (0, 1):
        return 2

    res = number
    while True:
        if is_prime(res):
            return res
        else:
            res += 1


t = int(sys.stdin.readline())
for _ in range(t):
    print(next_prime(int(sys.stdin.readline())))
