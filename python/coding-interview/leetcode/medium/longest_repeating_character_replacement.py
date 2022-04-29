from collections import defaultdict


def solution(s, k):
    count = defaultdict(int)
    res = 0

    left, maxf = 0, 0
    for r in range(len(s)):
        cur = s[r]
        count[cur] += 1
        maxf = max(maxf, count[cur])

assert solution("ABAB", 2) == 4
assert solution("AABABBA", 1) == 4
