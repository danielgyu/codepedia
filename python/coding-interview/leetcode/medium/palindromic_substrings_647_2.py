def count_substrings(s):
    count = 0

    def count_palindrome(start, end):
        if start < 0 or end > len(s)-1:
            return

        if s[start] != s[end]:
            return

        nonlocal count
        count += 1
        count_palindrome(start-1, end+1)

    for idx in range(len(s)):
        count += 1
        count_palindrome(idx, idx+1)
        count_palindrome(idx-1, idx+1)

    return count


if __name__ == "__main__":
    print(count_substrings("abc"))
    print(count_substrings("aaa"))  # a, a, a, aa, aa, aaa
    print(count_substrings("a"))
