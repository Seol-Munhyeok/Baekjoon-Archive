import sys


def is_perfect(number):
    """ 입력받은 수가 완전수인지 판단하고 이를 출력하는 함수"""

    factor_lst = []
    # n의 약수를 배열에 추가
    for i in range(1, number + 1):
        if number % i == 0:
            factor_lst.append(i)

    # 약수의 합 계산
    tmp = 0
    for factor in factor_lst:
        tmp += factor

    # 완전수 판별
    if tmp == 2 * number:
        length = len(factor_lst)
        print(f"{number} = ", end='')
        for j in range(length - 2):
            print(f"{factor_lst[j]}", end = ' + ')
        print(factor_lst[length - 2])
    else:
        print(f"{number} is NOT perfect.")


while True:
    n = int(sys.stdin.readline())
    if n == -1:
        break
    is_perfect(n)
