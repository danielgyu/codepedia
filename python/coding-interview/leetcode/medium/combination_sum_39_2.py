def combination_sum(candidates, target):
    res = []

    def dfs(total, idx, path):
        #print(f"{path=}, {idx=}, {total=}")
        if total == target:
            res.append(path)
            return

        if total > target:
            return

        for i in range(idx, len(candidates)):
            copied = path.copy()
            copied.append(candidates[i])
            dfs(total+candidates[i], i, copied)

    dfs(0, 0, [])
    print(res)
    return res


if __name__ == "__main__":
    combination_sum([2,3,6,7], 7)
    combination_sum([2,3,5], 8)
    combination_sum([2], 1)
