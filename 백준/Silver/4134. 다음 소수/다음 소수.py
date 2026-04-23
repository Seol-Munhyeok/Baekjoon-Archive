import sys, math


def is_prime(number):
    for i in range(2, math.ceil(math.sqrt(number)) + 1):
        if number % i == 0:
            return False
    return True


def next_prime(number):
    if number in (0, 1, 2):
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
