def subsets(nums):
    res = []

    def helper(lst, idx):
        res.append(lst.copy())

        for i in range(idx, len(nums)):
            copy_lst = lst.copy()
            copy_lst.append(nums[i])
            helper(copy_lst, i+1)

    helper([], 0)
    print(res)
    return res


if __name__ == "__main__":
    subsets([1,2,3])
    subsets([0])
    subsets([1,2,2])
