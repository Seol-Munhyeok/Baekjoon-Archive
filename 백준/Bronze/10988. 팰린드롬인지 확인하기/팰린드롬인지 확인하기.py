word = input()
n = len(word)


def is_palindrome(word):
    flag = True
    for i in range(n):
        if word[i] != word[n - i - 1]:
            flag = not flag
            break
    return flag


if is_palindrome(word):
    print("1")
else:
    print("0")

