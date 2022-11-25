def solution(candidates, target):
    res, subsets = [], []

    def dfs(subsets, idx):
        if sum(subsets) == target and subsets not in res:
            res.append(subsets.copy())

        if sum(subsets) > target or idx >= len(candidates):
            return

        subsets.append(candidates[idx])
        dfs(subsets, idx)
        subsets.pop()

        dfs(subsets, idx+1)

    dfs(subsets, 0)
    return res

if __name__ == "__main__":
    print(solution([2, 3, 6, 7], 7))
    print(solution([2], 1))
    print(solution([2,3,5], 8))
