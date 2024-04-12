def rob(nums):
    if len(nums) <= 2:
        return max(nums)

    r = [0] * len(nums)
    r[0], r[1] = nums[0], nums[1]
    r[2] = nums[0] + nums[2]

    for i in range(3, len(nums)):
        r[i] = max(
            r[i-1],
            nums[i]+r[i-2],
            nums[i]+r[i-3],
        )

    return r[-1]

if __name__ == "__main__":
    print(rob([1,2,3,1]))
    print(rob([2,7,9,3,1]))
