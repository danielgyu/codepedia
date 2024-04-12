def rob(nums):
    if len(nums) < 4:
        return max(nums)

    total_length = len(nums)
    # start form idx 0
    from_z = [0] * (total_length-1)
    from_z[0], from_z[1] = nums[0], nums[1]
    from_z[2] = max(from_z[0]+nums[2], from_z[1])
    for i in range(3, total_length-1):
        from_z[i] = max(
            from_z[i-2]+nums[i],
            from_z[i-3]+nums[i],
            from_z[i-1],
        )

    # start form idx 1
    from_o = [0] * (total_length-1)
    from_o[0], from_o[1] = nums[1], nums[2]
    from_o[2] = max(from_o[0]+nums[3], from_o[1])
    for i in range(3, total_length-1):
        from_o[i] = max(
            from_o[i-2]+nums[i+1],
            from_o[i-3]+nums[i+1],
            from_o[i-1],
        )

    print(from_z, from_o)
    return max(from_z[-1], from_o[-1])

if __name__ == "__main__":
    """
    print(rob([2, 3, 2]))
    print(rob([1, 2, 3, 1]))
    print(rob([1, 2, 3]))
    print(rob([200,3,140,20,10]))
    """
    print(rob([2,7,9,3,1]))
