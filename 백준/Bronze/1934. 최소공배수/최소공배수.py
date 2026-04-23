import sys


def get_gcd(x, y):
    """ 유클리드 알고리즘 사용 """
    # x를 더 큰 값으로 만듦
    if x < y:
        x, y = y, x
    while y != 0:
        remainder = x % y
        x = y
        y = remainder
    return x


def get_lcm(x, y):
    """ 최대공약수와 최소공배수 사이의 관계 이용"""
    return (x * y) // get_gcd(x, y)


t = int(sys.stdin.readline())
for _ in range(t):
    a, b = map(int, sys.stdin.readline().split())
    print(get_lcm(a, b))
