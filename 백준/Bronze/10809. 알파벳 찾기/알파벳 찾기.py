s = input()
lst, res_lst, tmp = [], [], []

for a in range(26):
    res_lst.append(-1)

for i in range(97, 123):
    lst.append(chr(i))

for j in range(len(s)):
    tmp.append(s[j])
    for k in range(26):
        if s[j] == lst[k] and tmp.count(s[j]) == 1:
            res_lst[k] = j


print(*res_lst)