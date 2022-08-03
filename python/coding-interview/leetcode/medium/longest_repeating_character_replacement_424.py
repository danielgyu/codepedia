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
    return res

def solution_leetcode(s, k):
    left, right, longest = 0, 0, 0
    counter_dict = defaultdict(int)

    while left < len(s) and right < len(s):
        counter_dict[s[right]] += 1
        most = max(counter_dict.values())

        while (left < right and
               (right-left+1) - most > k):
            counter_dict[s[left]] -= 1
            left += 1
            most = max(counter_dict.values())
        
        # if (right-left+1) == 4: breakpoint()
        longest = max(longest, right-left+1)
        right += 1

    return longest

def solution_leetcode(s, k):
    counter_dict = defaultdict(int)
    left, longest = 0, 0

    for right in range(len(s)):
        counter_dict[s[right]] += 1
        window = right - left + 1
        most = max(counter_dict.values())

        if window - most <= k:
            longest = window
        else:
            counter_dict[s[left]] -= 1
            left += 1

    return longest

#assert solution("ABAB", 2) == 4
#assert solution("AABABBA", 1) == 4
print(solution_leetcode("FSGABCG", 3))  # == 5
print(solution_leetcode("FCDABBBA", 3))  #  == 6
print(solution_leetcode("AABABBA", 1))  # == 4
print(solution_leetcode("ABAB", 2))  # == 4
print(solution_leetcode("ABCDEFGHII", 0))  # == 2
print(solution_leetcode("ABBC", 2))  # == 4
print(solution_leetcode("ABBB", 2))  # == 4
