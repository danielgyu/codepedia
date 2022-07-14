def solution(strs):
    from collections import defaultdict
    res = defaultdict(list)

    for s in strs:
        sorted_s = "".join(sorted(s))
        res[sorted_s].append(s)

    return res.values()

def solution_0714(strs):
    from collections import defaultdict
    res = defaultdict(list)

    for s in strs:
        sorted_s = "".join(sorted(s))
        res[sorted_s].append(s)

    return [v for v in res.values()]

solution(["eat", "tea", "tan", "ate", "nat", "bat"])
solution(["a"])
solution([""])
solution(["", ""])

print(solution_0714(["eat", "tea", "tan", "ate", "nat", "bat"]))
