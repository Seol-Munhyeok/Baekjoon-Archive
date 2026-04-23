import sys
import math

a, b = map(int, sys.stdin.readline().split())
x, y = map(int, sys.stdin.readline().split())

numerator = b * y
denominator = a * y + b * x
div_value = math.gcd(numerator, denominator)
numerator //= div_value
denominator //= div_value

print(denominator, numerator)
