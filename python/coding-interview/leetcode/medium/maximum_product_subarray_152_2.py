def max_product(nums):
    cur_max = cur_min = max_prod = nums[0]

    for n in nums[1:]:
        candidates = (n, cur_min * n, cur_max * n)
        cur_min = min(candidates)
        cur_max = max(candidates)
        max_prod = max(max_prod, cur_max)

    return max_prod


if __name__ == "__main__":
    """
    print(max_product([1,0,-1,2,3,-5,-2]))
    print(max_product([0, 2]))
    print(max_product([-2]))
    print(max_product([2, 3, -2, 4]))
    print(max_product([-2, 0, -1]))
    print(max_product([3, -1, 4, -8, -2]))
    """
    print(max_product([3, 2, 3, -1, 4, -8, -100]))
