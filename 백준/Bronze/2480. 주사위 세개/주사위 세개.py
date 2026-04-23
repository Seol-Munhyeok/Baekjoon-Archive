lst = list(map(int, input().split()))


def find_prize(arr):
    for i in range(len(arr)-1):
        for j in range(i+1, len(arr)):
            target = arr[i]
            if target == arr[j]:
                return target
    return max(arr)


def all_same(arr):
    temp = arr[0]
    for i in range(1, len(arr)):
        if temp != arr[i]:
            return False
    return True


def all_diff(arr):
    for i in range(len(arr)-1):
        for j in range(i+1, len(arr)):
            if arr[i] == arr[j]:
                return False
    return True


if all_same(lst):
    print(10000 + find_prize(lst) * 1000)
elif all_diff(lst):
    print(find_prize(lst) * 100)
else:
    print(1000 + find_prize(lst) * 100)