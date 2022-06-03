def solution(s):
    if len(s) == 1:
        return s

    if len(s) == 2:
        return s[0] if s[0] != s[1] else s

    def check_palindrome(left, right):
        palindrome = s[left]
        while left >= 0 and right <= len(s)-1:
            if s[left] == s[right]:
                palindrome = s[left:right+1]
                left -= 1
                right +=1
            else:
                break
        return palindrome

    longest = s[0]
    for i in range(len(s)):
        even = check_palindrome(i, i+1)
        odd = check_palindrome(i-1, i+1)
        longest = sorted([longest, even, odd], key=len)[-1]

    print(f"longest: {longest}")
    return longest


if __name__ == "__main__":
    solution("babad")
    solution("cbbd")
    solution("ccd")
