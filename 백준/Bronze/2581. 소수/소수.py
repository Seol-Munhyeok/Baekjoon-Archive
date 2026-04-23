import math


def is_prime(number):
    """
    :param number: int
    :return: number가 소수면 1, 소수가 아니면 0을 반환
    """

    if number == 1:
        return 0

    for d in range(2, math.floor(math.sqrt(number)) + 1):
        if number % d == 0:
            return 0
    return 1


m = int(input())
n = int(input())
prime_lst = [num for num in range(m, n+1) if is_prime(num) == 1]

if len(prime_lst) == 0:
    print(-1)
else:
    print(sum(prime_lst))
    print(min(prime_lst))
