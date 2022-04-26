def solution(nums):
    if len(nums) == 1:
        return nums[0]

    res = -1
    cur_min, cur_max = 1, 1

    for n in nums:
        tmp = n * cur_max
        cur_max = max(n, n * cur_max, n * cur_min)
        cur_min = min(n, tmp, n * cur_min)
        res = max(res, cur_max)

    # print(res)
    return res


assert solution([2, 3, -2, 4]) == 6
assert solution([-2, 0, -1]) == 0
assert solution([-4, -3, -2]) == 12
assert solution([-2, 3, -4]) == 24
