def can_jump(nums):
    max_idx = 0
    for i in range(len(nums)-1):
        if max_idx < i:
            return False

        max_idx = max(max_idx, i+nums[i])

    #print(f"{max_idx=}")
    return max_idx >= len(nums)-1


if __name__ == "__main__":
    print(can_jump([2, 3, 1, 1, 4]))
    print(can_jump([3, 2, 1, 0, 4]))
    print(can_jump([1]))
    print(can_jump([0, 2, 3]))
