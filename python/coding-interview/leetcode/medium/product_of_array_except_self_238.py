def solution(nums):
    res = [1 for _ in range(len(nums))]

    start = 1
    for i in range(1, len(nums)):
        left = nums[i-1]
        res[i] = left * start
        start *= left 

    # print(f"middle: {res}")

    start = 1
    for i in range(len(nums)-2, -1, -1):
        right = nums[i+1]
        res[i] = right * start * res[i]
        start *= right

    return res


if __name__ == "__main__":
    print(solution([1, 2, 3, 4]))
    print(solution([2, 3, 4, 5]))  # 60, 40, 30, 24
    print(solution([-1, 1, 0, -3, 3]))
