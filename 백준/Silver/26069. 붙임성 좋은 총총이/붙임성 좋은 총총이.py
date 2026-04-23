import sys
from collections import defaultdict

n = int(sys.stdin.readline())
is_danced = defaultdict(lambda : False)
cnt, res = 0, 0
while True:
    a, b = map(str, sys.stdin.readline().strip().split())
    cnt += 1
    if a == 'ChongChong' or b == 'ChongChong':
        is_danced[a] = True
        is_danced[b] = True
        break

for _ in range(n-cnt):
    a, b = map(str, sys.stdin.readline().strip().split())
    if is_danced[a] or is_danced[b]:
        is_danced[a] = True
        is_danced[b] = True

for keys in is_danced.keys():
    if is_danced[keys]:
        res += 1
print(res)
