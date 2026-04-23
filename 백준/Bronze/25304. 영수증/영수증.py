import sys

total_price = int(input())
count = int(input())
temp_price = 0
for i in range(count):
    a, b = map(int, sys.stdin.readline().split())
    temp_price += a * b
if temp_price == total_price:
    print("Yes")
else:
    print("No")