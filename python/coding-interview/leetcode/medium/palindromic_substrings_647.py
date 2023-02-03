def solution(s):
    count = 0

    def get_palindrome(left, right):
        nonlocal count
        
        while left >= 0 and right < len(s):
            if not s[left] == s[right]:
                break

            count += 1
            left, right = left-1, right+1

    for i in range(len(s)):
        get_palindrome(i, i)
        get_palindrome(i, i+1)

    return count


if __name__ == "__main__":
    print(solution("abc"))
    print(solution("aaa"))
