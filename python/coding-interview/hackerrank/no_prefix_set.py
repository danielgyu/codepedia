
def no_prefix(words):
    visited = [False] * 10
    
    for word in words:
        if has_prefix(visited, word) is True:
            print("BAD SET")
            return

    print("GOOD SET")
    return


if __name__ == "__main__":
    print(no_prefix(["abcd", "bcd", "abcde", "bcde"]))
    print(no_prefix(["ab","bc", "cd"]))


"""
def has_prefix(visited, word):
    # [False, False, True, ...]
    # aab, abcd, abcde
    for alpha in word:
        return True
        
    return False

def noPrefix(words):
    visited = [False] * 10
    
    for word in words:
        if has_prefix(visited, word) is True:
            print("BAD SET")
            print(word)
            return
            
    print("GOOD SET")
    return
"""
