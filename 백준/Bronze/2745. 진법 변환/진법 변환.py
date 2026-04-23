# 입력받은 b진법 수 n을 문자열로 받아서 각 문자를 리스트에 추가
n, b = map(str, input().split())
b = int(b)
num_lst = [char for char in n]

# 각 문자를 정수형으로 변환하여 리스트 수정
length = len(num_lst)
for i in range(length):
    try:
        num_lst[i] = int(num_lst[i])
    except ValueError:
        num_lst[i] = ord(num_lst[i]) - 55

# 각 자리수 마다 곱해질 가중치를 나타내는 리스트 선언
exp_lst = [b ** value for value in range(length-1, -1, -1)]

# 각 자리수와 가중치를 곱하고 각각 더하여 10진법으로 변환
res = 0
for i in range(length):
    res += num_lst[i] * exp_lst[i]

print(res)
