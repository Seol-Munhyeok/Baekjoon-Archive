a, b = map(str, input().split())
reverse_a = int(a[::-1])
reverse_b = int(b[::-1])

print(max(reverse_a, reverse_b))
