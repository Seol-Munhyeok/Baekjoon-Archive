W, N, P = map(int, input().split())
punchs = list(map(int, input().split()))
answer = 0

for p in punchs:
    if W <= p <= N:
        answer += 1

print(answer)