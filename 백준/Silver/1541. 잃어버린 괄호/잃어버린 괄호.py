equation = input()
tmp = equation.split('-')
calculated_lst = []

for term in tmp:
    if '+' not in term:
        calculated_lst.append(int(term))
    else:
        plus = term.split('+')
        calculated_lst.append(sum(int(num) for num in plus))

first = calculated_lst[0]
if len(calculated_lst) == 1:
    res = first
else:
    for i in range(1, len(calculated_lst)):
        res = first - calculated_lst[i]
        first = res

print(res)
