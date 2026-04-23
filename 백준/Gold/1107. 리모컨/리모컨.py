n = int(input())
m = int(input())
broken = set(map(int, input().split())) if m else set()

def usable(x):
    if x == 0:
        return 0 not in broken
    while x:
        if x % 10 in broken:
            return False
        x //= 10
    return True

ans = abs(n - 100)
for x in range(1000000):  # 0 ~ 999,999
    if usable(x):
        ans = min(ans, len(str(x)) + abs(n - x))
print(ans)
