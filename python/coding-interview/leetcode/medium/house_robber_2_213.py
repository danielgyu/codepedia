def rob(nums):
    left, right = 0, 0
    for i in range(len(nums)):
        left, right = right, max(left+nums[i], right)
    return right

def solution(nums):
    if len(nums) == 1:
        return nums[0]

    return max(rob(nums[1:]), rob(nums[:-1]))


if __name__ == "__main__":
    print(solution([1]), 1)
    print(solution([2, 1]), 2)
    print(solution([2,3,2]), 3)
    print(solution([1,2,3,1]), 4)
    print(solution([1,2,3]), 3)
    print(solution([5,3,1,9,0,1,9]), 21)
