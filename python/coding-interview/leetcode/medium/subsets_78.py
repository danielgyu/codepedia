def solution(nums):
    res = []
    subset = []

    def backtrack(idx):
        if idx >= len(nums):
            res.append(subset.copy())
            return

        subset.append(nums[idx])
        backtrack(idx+1)
        subset.pop()
        backtrack(idx+1)

    backtrack(0)
    return res


if __name__ == "__main__":
    print(solution([1,2,3]))
