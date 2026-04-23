def find_group(term):
    """ term 번째 항이 어떤 군에 속하는 지를 구하는 함수 """
    left, right = 1, term

    while left <= right:
        mid = (left + right) // 2
        value = mid * (mid + 1) // 2

        if value <= term:
            left = mid + 1
        else:
            right = mid - 1
    return right


def append_group(group):
    tmp = []
    numerator, denominator = 1, group
    while len(tmp) < group:
        value = str(numerator) + "/" + str(denominator)
        tmp.append(value)
        numerator += 1
        denominator -= 1

    # 홀수번째 군은 역순으로 나열해야함
    if group % 2 == 1:
        tmp.reverse()
    return tmp


n = int(input())
group = find_group(n)
end_n_group = group * (group + 1) // 2    # 제 n군의 마지막 항

if end_n_group < n:
    group += 1
    term_n_next_group = n - end_n_group    # n이 제 n+1군에서 몇 번째 항인지를 나타냄
    my_group = append_group(group)
    print(my_group[term_n_next_group - 1])
elif end_n_group == n:
    my_group = append_group(group)
    print(my_group[-1])
