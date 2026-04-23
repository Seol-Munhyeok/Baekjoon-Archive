import sys

n = int(sys.stdin.readline())
count_lst = [0] * 10001

for _ in range(n):
    num = int(sys.stdin.readline())
    count_lst[num] += 1

for max_index in range(10000, -1, -1):
    if count_lst[max_index] != 0:
        break
        
for i in range(1, max_index + 1):
    for _ in range(count_lst[i]):
        print(i)
