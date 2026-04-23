import sys


def is_group_word(word):
    letter_lst = list(set(word))
    for letter in letter_lst:
        tmp = word.count(letter)
        if letter * tmp not in word:
            return 0
    return 1


n = int(sys.stdin.readline())
res = 0

for i in range(n):
    word = sys.stdin.readline()
    res += is_group_word(word)

print(res)
