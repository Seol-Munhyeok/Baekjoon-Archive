def prime_factorization(n):
    factors = []

    while n % 2 == 0:
        factors.append(2)
        n //= 2

    # 3 이상의 홀수로 나누기
    for i in range(3, int(n**0.5) + 1, 2):
        while n % i == 0:
            factors.append(i)
            n //= i

    # 남은 n이 소수인 경우
    if n > 2:
        factors.append(n)

    return len(factors)


a, b = map(int, input().split())
cnt = 0
for num in range(a, b+1):
    length = prime_factorization(num)
    if prime_factorization(length) == 1:
        cnt += 1

print(cnt)
