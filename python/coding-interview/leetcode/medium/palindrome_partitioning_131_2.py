def is_palindrome(s):
    if len(s) == 1:
        return True

    elif len(s) % 2 == 0:
        mid = len(s) // 2
        left, right = mid-1, mid
        while left >= 0 and right < len(s):
            if s[left] != s[right]:
                return False
            left -= 1
            right += 1
    else:
        mid = len(s) // 2
        left, right = mid-1, mid+1
        while left >= 0 and right < len(s):
            if s[left] != s[right]:
                return False
            left -= 1
            right += 1

    return True

def partition(st):
    # a b a 
    # a b b a c a
    res = []

    def palindrome(cur, lst, idx):
        if idx >= len(st)-1:
            if is_palindrome(cur):
                lst.append(cur)
                res.append(lst)
            return

        # pass down next cur
        if is_palindrome(cur):
            copied = lst.copy()
            copied.append(cur)
            palindrome(st[idx+1], copied, idx+1)

        # pass down cur+next
        palindrome(cur+st[idx+1], lst, idx+1)

    palindrome(st[0], [], 0)
    print(res)
    return res


if __name__ == "__main__":
    partition("aab")
    partition("a")
    partition("abbaca")
