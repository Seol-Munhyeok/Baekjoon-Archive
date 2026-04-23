two_word_lst = ['c=', 'c-', 'd-', 'lj', 'nj', 's=', 'z=']
three_word_lst = ['dz=']
two_word_count, three_word_count = 0, 0

word = input()

for letter in two_word_lst:
    two_word_count += word.count(letter)

for letter in three_word_lst:
    three_word_count += word.count(letter)
    # 'dz='가 포함되었다면 'z='가 의미 없이 하나 더 세어졌으므로 빼준다.
    two_word_count -= word.count(letter)

res = len(word) - (two_word_count + three_word_count * 2)
print(res)
