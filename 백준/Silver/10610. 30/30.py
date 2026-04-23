num = input()
digits = []
digit_sum = 0

for digit in range(len(num)):
    digits.append(num[digit])
    digit_sum += int(num[digit])

if '0' in digits and digit_sum % 3 == 0:
    digits.sort(reverse=True)
    res = ''.join(digits)
    print(res)
else:
    print(-1)
