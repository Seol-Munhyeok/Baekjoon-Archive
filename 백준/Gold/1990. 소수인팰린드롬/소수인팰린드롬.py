import math, sys

n, m = map(int, sys.stdin.readline().split())
if n % 2 == 0:
    n += 1
# 10000000 보다 큰 수에 대해서는 펠린드롬인 소수가 없음.
if m > 10000000:
    m = 10000000
    

def is_palindrome(num):
    num_str = str(num)
    return num_str == num_str[::-1]


def is_prime(number):
    # 입력이 5이상인 정수이므로, 홀수만 검사함
    for i in range(3, int(math.sqrt(number)) + 1, 2):
        if number % i == 0:
            return False
    return True


for num in range(n, m+1, 2):
    if is_palindrome(num) and is_prime(num):
        print(num)
print(-1)
