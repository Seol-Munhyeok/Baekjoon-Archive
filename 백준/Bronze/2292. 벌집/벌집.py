def get_max_address(n):
    """ 방의 번호 n이 주어질 때, 주소의 최댓값을 구하는 함수
     f(1) = 1
     f(2) = 7
     f(3) = 19
     f(4) = 37 ...
     f(n) = f(n-1) + 6(n-1)의 점화 관계가 나옴
     이는 공차가 6(n-1)인 등차수열과 같고 이를 통해 일반항을 구하면
     f(n) = f(1) + 6(1+2+3+...+(n-1))
     이고 등차수열의 합 공식을 적용하면 일반항이 나온다. """

    return 1 + 6 * n * (n-1) / 2


room_address = int(input())
cnt = 1
while True:
    if room_address <= get_max_address(cnt):
        break
    else:
        cnt += 1

print(cnt)
