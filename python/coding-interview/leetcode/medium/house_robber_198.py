def solution(nums):
    l = [0 for _ in range(len(nums))]
    l[0], l[1] = nums[0], nums[1]
    max_num = max(l[0], l[1])

    for i in range(2, len(nums)):
        l[i] = max(l[i-1], l[i-2]+nums[i], max_num+nums[i])
        max_num = max(max_num, nums[i])

    print(f"{l=}")
    return l[-1]


def solution2(nums):
    left, right = 0, 0

    for num in nums:
        left, right = right, max(left+num, right)

    return right


if __name__ == "__main__":
    print(solution([1,2,3,1]))
    print(solution([5,3,1,9,3,0,1]))

    print(solution2([1,2,3,1]))
    print(solution2([5,3,1,9,3,0,1]))
    print(solution2([2, 1]))
