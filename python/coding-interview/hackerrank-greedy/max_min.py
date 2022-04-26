import math

def max_min(k, arr):
    arr.sort()
    left, right = 0, k-1

    diff = math.inf
    while right < len(arr):
        cur_diff = arr[right] - arr[left]
        diff = min(diff, cur_diff)

        left += 1
        right += 1

    return diff

assert max_min(3, [10, 100, 300, 200, 1000, 20, 30]) == 20
assert max_min(4, [1, 2, 3, 4, 10, 20, 30, 40, 100, 200]) == 3
assert max_min(2, [1, 2, 1, 2, 1]) == 0

