lst = []

num = 666
while len(lst) <= 10000:
    if '666' in str(num):
        lst.append(num)
    num += 1

n = int(input())
print(lst[n-1])
