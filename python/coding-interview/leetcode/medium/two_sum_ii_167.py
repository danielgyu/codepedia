def solution(nums, target):
    left, right = 0, len(nums)-1
    while left < right:
        l, r = nums[left], nums[right]

        if l + r == target:
            return [left+1, right+1]
        elif l + r < target:
            left += 1
        else:
            right -= 1


if __name__ == "__main__":
    print(solution([2, 7, 11, 15], 9))
    print(solution([2, 3, 4], 6))
    print(solution([-1, 0], -1))
