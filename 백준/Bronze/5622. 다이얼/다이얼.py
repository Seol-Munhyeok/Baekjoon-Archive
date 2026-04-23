dic = dict()
lst = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
s = input()
res = 0

for i in range(3, 11):
    dic[lst[i-3]] = i

for j in range(len(s)):
    for k in range(8):
        if s[j] in list(dic.keys())[k]:
            res += dic[list(dic.keys())[k]]

print(res)
