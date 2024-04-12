def subset(nums):
    nums.sort()
    res = []
    tracker = set()

    def dfs(cur, idx):
        if cur not in tracker:
            res.append(list(cur))
            tracker.add(cur)

        for i in range(idx, len(nums)):
            copied = cur + (nums[i],)
            dfs(copied, i+1)

    dfs((), 0)
    print(res)
    return res


if __name__ == "__main__":
    subset([1, 2, 2])
    subset([0])
    subset([4,4,4,1,4])
    subset([1,4,4,4,4])
