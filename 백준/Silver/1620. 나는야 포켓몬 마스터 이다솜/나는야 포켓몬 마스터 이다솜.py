import sys

n, m = map(int, sys.stdin.readline().split())
pokemon_dex = {}
idx = 1
for _ in range(n):
    pokemon_dex[idx] = sys.stdin.readline().strip()
    idx += 1
reversed_dex = {value: key for key, value in pokemon_dex.items()}
for _ in range(m):
    test = sys.stdin.readline().strip()
    if test.isdigit():
        print(pokemon_dex.get(int(test)))
    else:
        print(reversed_dex.get(test))
