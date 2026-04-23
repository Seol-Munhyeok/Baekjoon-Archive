""" 굳이 일반항을 찾는 노력없이 while문을 통해 쉽게 각 방의 최대 주소를 찾을 수 있다. """

n = int(input())

num_house = 1  # 벌집의 개수
cnt = 1  # 각 벌집의 최대 주소값

while n > cnt:
    cnt = cnt + 6 * num_house  # 벌집의 최대 주소값을 증가시킴
    num_house += 1

print(num_house)
