import sys


n = int(sys.stdin.readline())
unsorted_lst = [int(sys.stdin.readline()) for _ in range(n)]


def insertion_sort(lst, size):
    for i in range(1, n):
        key = lst[i]
        j = i - 1
        while j >= 0 and lst[j] > key:
            lst[j+1] = lst[j]
            j -= 1
        lst[j+1] = key
    return lst


[print(item) for item in insertion_sort(unsorted_lst, n)]
