a = int(input())
b = int(input())
b_one = b % 10
b_ten = (b // 10) % 10
b_hund = (b // 100)

x = a * b_one
y = a * b_ten
z = a * b_hund

res = x + 10 * y + 100 * z

print(x)
print(y)
print(z)
print(res)