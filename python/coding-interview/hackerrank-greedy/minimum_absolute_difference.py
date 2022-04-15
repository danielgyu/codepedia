from math import inf

def solution(arr):
    arr.sort()

    diff = inf
    for i in range(1, len(arr)):
        cur = abs(arr[i] - arr[i-1])
        if cur < diff:
            diff = cur

    return diff


print(solution([-59, -36, -13, 1, -53, -92, -2, -96, -54, 75]))
print(solution([1, -3, 71, 68, 17]))
