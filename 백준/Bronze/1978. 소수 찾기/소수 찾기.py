import math
import sys


def is_prime(number):
    if number == 1:
        return 0

    for d in range(2, math.floor(math.sqrt(number)) + 1):
        if number % d == 0:
            return 0
    return 1


res = 0
n = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))

for i in range(n):
    res += is_prime(lst[i])

print(res)
