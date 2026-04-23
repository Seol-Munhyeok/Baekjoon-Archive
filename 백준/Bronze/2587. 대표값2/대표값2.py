import sys

lst = []
for _ in range(5):
    lst.append(int(sys.stdin.readline()))

lst.sort()
avg = sum(lst) // 5
mid = lst[2]

print(avg)
print(mid)
