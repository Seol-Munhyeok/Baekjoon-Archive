import sys

# 2이상 n이하의 소수를 리스트에 추가
m, n = map(int, sys.stdin.readline().split())
is_prime = [True] * (n + 1)    # 처음엔 모든 수가 소수(True)인 것으로 초기화
for i in range(2, int(n ** 0.5) + 1):
    if is_prime[i]:    # i가 소수인 경우
        # i의 배수들을 바로 False로 설정하여 소수를 제거
        is_prime[i * i: n + 1: i] = [False] * len(range(i * i, n + 1, i))

prime_lst = [i for i in range(2, n+1) if is_prime[i]]

# 소수 리스트 중 m 이상의 수만 출력
k = 0
while True:
    if m <= prime_lst[k]:
        try:
            for j in range(k, len(prime_lst) + 1):
                print(prime_lst[j])
        except IndexError:
            break
    else:
        k += 1
