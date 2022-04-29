from collections import defaultdict


def solution(s, k):
    count = defaultdict(int)
    res = 0

    l, maxf = 0, 0
    for r in range(len(s)):
        cur = s[r]
        count[cur] += 1
        maxf = max(maxf, count[cur])

        while (r - l + 1) - maxf > k:
            count[s[l]] -= 1
            l += 1

        res = max(res, r - l + 1)
    print(f"{res=}, {count=}")
    return res

assert solution("ABAB", 2) == 4
assert solution("AABABBA", 1) == 4
