E, S, M = map(int, input().split())
e, s, m = 1, 1, 1

res = 1
while True:
    if (E, S, M) == (e, s, m):
        break
    res += 1

    e += 1
    if e == 16:
        e = 1

    s += 1
    if s == 29:
        s = 1

    m += 1
    if m == 20:
        m = 1

print(res)
