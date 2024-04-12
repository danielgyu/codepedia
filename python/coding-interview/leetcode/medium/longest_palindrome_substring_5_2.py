def longest_palindrome(s):
    longest = ""

    def get_palindrom(left, right):
        while left >= 0 and right < len(s):
            #print(f"{left=}, {right=}, {s[left]=}, {s[right]=}")
            if s[left] != s[right]:
                break

            left -= 1
            right += 1

        nonlocal longest
        cur_longest = s[left+1:right]
        if len(cur_longest) > len(longest):
            longest = cur_longest

    for i in range(len(s)):
        get_palindrom(i, i)
        get_palindrom(i, i+1)

    return longest


if __name__ == "__main__":
    print(longest_palindrome("babad"))
    print(longest_palindrome("cbbd"))
    print(longest_palindrome("a"))
