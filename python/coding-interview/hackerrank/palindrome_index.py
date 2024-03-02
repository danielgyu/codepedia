def palindromeIndex(s):
    ret = -1

    def recurse(left, right, changed_idx):
        while left <= right:
            if s[left] != s[right]:
                break
            left += 1
            right -=1

        if left >= right:
            nonlocal ret
            ret = changed_idx
            return
    
        if changed_idx != -1:
            return

        recurse(left+1, right, left)
        recurse(left, right-1, right)
        

    recurse(0, len(s)-1, -1) 
    print(ret)
    return ret


palindromeIndex("aaab")
palindromeIndex("baa")
palindromeIndex("aaa")
