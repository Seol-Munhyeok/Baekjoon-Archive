def prt_blank(n):
    print(" " * n, end='')


def prt_star(n):
    print("*" * n, end='')


m = int(input())
for i in range(1, 2*m, 2):
    prt_blank((2 * m - 1 - i)//2)
    prt_star(i)
    print("")

for j in range(2*m-3, 0, -2):
    prt_blank((2 * m - 1 - j) // 2)
    prt_star(j)
    if j != 1:
        print("")