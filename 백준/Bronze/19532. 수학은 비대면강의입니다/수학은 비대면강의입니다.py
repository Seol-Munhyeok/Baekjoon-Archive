a, b, c, d, e, f = map(int, input().split())


def equation_1(x, y):
    return a * x + b * y == c


def equation_2(x, y):
    return d * x + e * y == f


for i in range(-999, 1000):
    for j in range(-999, 1000):
        flag = equation_1(i, j) and equation_2(i, j)
        if flag:
            print(i, j)
            break
