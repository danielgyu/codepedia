def solution(nums):
    res, unique = list(), set()
    l = 0
    nums.sort()

    while l < r-1:
        t, r = l + 1, len(nums)-1

        while t < r:
            l_num, t_num, r_num = nums[l], nums[t], nums[r]
            if (l_num + t_num + r_num == 0 and
                hash(f"{l_num}{t_num}{r_num}") not in unique):
                res.append([l_num, t_num, r_num])
                unique.add(hash(f"{l_num}{t_num}{r_num}"))

            if l_num + t_num + r_num <= 0:
                t += 1
            else:
                r -=1

        original = nums[l]
        while l < r-1 and nums[l] == original:
            l += 1

    return res

if __name__ == "__main__":
    print(solution([-1, 0, 1, 2, -1, -4]))
    print(solution([0, 1, 1]))
    print(solution([0, 0, 0, 0]))
    print(solution([-1,0,1,2,-1,-4,-2,-3,3,0,4]))
    # [-4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4]
