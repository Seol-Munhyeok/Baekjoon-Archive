string = input()
length = len(string)
sub_string = []

for i in range(length):
    for j in range(i, length):
        sub_string.append(string[i:j+1])

res = len(set(sub_string))
print(res)
