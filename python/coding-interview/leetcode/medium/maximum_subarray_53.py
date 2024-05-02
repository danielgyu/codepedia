def max_sub_array(nums):
    cur_sum, max_sum = 0, 0

    for num in nums:
        if num > cur_sum+num:
            cur_sum = num
        else:
            cur_sum += num

        max_sum = max(max_sum, cur_sum)

    return max_sum


if __name__ == "__main__":
    print(max_sub_array([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
    print(max_sub_array([1]))
    print(max_sub_array([5, 4, -1, 7, 8]))
    print(max_sub_array([1, 2]))
