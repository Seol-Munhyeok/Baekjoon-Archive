import sys
from collections import defaultdict

n = int(sys.stdin.readline())
my_cards = list(map(int, sys.stdin.readline().split()))
card_dict = defaultdict(int)

for num in my_cards:
    card_dict[num] += 1

m = int(sys.stdin.readline())
card_count = list(map(int, sys.stdin.readline().split()))

[print(card_dict[num], end=' ') for num in card_count]
