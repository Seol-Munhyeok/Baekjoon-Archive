word_lst = ['c=', 'c-', 'd-', 'lj', 'nj', 's=', 'z=']
word_lst_three = ['dz=']
word = input()

for letter in word_lst_three:
    word = word.replace(letter, "*")

for letter in word_lst:
    word = word.replace(letter, "*")

print(len(word))
