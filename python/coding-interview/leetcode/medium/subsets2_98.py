def solution(nums):
    def backtrack(idx, res):
        ans.append(res[:])

        for i in range(idx, len(nums)):
            if i > idx and nums[i] == nums[i-1]:
                print(f"{i=}, {idx=}")
                continue

            res.append(nums[i])
            backtrack(i+1, res)
            res.pop()

    nums.sort()
    ans = []
    backtrack(0, [])
    return ans


if __name__ == "__main__":
    print(solution([1, 2, 2]))
    #print(solution([1, 2, 3]))
