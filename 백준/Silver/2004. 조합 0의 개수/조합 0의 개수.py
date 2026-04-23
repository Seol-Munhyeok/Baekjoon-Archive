n, m = map(int, input().split())


def get_exponent_count(num, x):
    """
    :param num, x: int
    :return: num!에 x가 곱해져 있는 개수
    """
    cnt = 0
    i = 1
    while num >= x ** i:
        tmp = num // x ** i
        cnt += tmp
        i += 1
    return cnt


cnt2 = get_exponent_count(n, 2) - (get_exponent_count(n-m, 2) + get_exponent_count(m, 2))
cnt5 = get_exponent_count(n, 5) - (get_exponent_count(n-m, 5) + get_exponent_count(m, 5))
print(min(cnt2, cnt5))
