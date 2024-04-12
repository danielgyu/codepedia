def solution(nums, target):
    nums.sort()
    result = []

    def backtrack(start, path, target):
        print(f"{path=}")
        if target == 0:
            result.append(path)
            return

        for i in range(start, len(nums)):
            if i > start and nums[i] == nums[i-1]:
                print(f"{i=}, {start=}")
                continue

            if nums[i] > target:
                break

            backtrack(i+1, path+[nums[i]], target-nums[i])

    backtrack(0, [], target)
    return result


if __name__ == "__main__":
    #print(solution([1, 2, 2, 2, 5], 5))
    print(solution([10, 1, 2, 7, 6, 1, 5], 8))  #[1, 1, 2, 5, 6, 7, 10]
