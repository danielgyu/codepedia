def solution(nums, k):
    mod_map = dict()
    mod_map[0] = -1

    accum = 0
    for i, n in enumerate(nums):
        accum += n
        mod = accum % k

        if mod_map.get(mod) != None:
            if i - mod_map[mod] >= 2:
                return True
        else:
            mod_map[mod] = i

    return False


assert solution([23, 2, 4, 6, 7], 6) == True
assert solution([23, 2, 6, 4, 7], 13) == False
assert solution([23, 2, 4, 6, 6], 7) == True
