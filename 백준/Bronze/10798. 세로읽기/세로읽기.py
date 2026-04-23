lst = [input() for _ in range(5)]
str_lst = []
row, col, max_len = 0, 0, 0

for i in range(5):
    if max_len <= len(lst[i]):
        max_len = len(lst[i])

for i in range(5):
    if len(lst[i]) < max_len:
        count = max_len - len(lst[i])
        lst[i] = lst[i] + "*" * count

while row < max_len:
    str_lst.append(lst[col][row])
    if col < 4:
        col += 1
    else:
        col = 0
        row += 1

str_lst = [value for value in str_lst if value != "*"]
for i in range(len(str_lst)):
    print(str_lst[i], end='')
    