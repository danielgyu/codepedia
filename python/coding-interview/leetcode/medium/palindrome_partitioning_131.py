def solution(s):
    res = []
    path = []

    def dfs(idx):
        if idx >= len(s):
            res.append(path.copy())
            return

        for i in range(idx, len(s)):
            if is_palindrome(s, idx, i):
                path.append(s[idx:i+1])
                dfs(i+1)
                path.pop()

    dfs(0)
    return res


def is_palindrome(s, left, right):
    while left < right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True


if __name__ == "__main__":
    print(solution("aab"))  # [["a", "a", "b"], ["aa", "b"]]
    #print(solution("a"))
