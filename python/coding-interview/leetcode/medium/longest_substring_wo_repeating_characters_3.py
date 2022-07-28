def solution(s):
    s_dict = dict()
    left, right = 0, 0
    longest = 0

    for idx, c in enumerate(s):
        right = idx
        if c in s_dict and s_dict[c] >= left:
            left = s_dict[c] + 1
        else:
            longest = max(longest, right-left+1)
        s_dict[c] = idx

    # print(f"{left=}, {right=}, {s_dict=}")
    return longest


if __name__ == "__main__":
    print(solution("zaabcdez"))
    print(solution("bbb"))
    print(solution("abcdef"))
    print(solution("bbbbb"))
    print(solution("abcabcbb"))
    print(solution("pwwkew"))
    print(solution("tmmzuxt"))
