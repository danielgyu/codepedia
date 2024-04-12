def optimized(st, word_dict):
    dp = [False]*(len(st)+1)
    dp[0] = True

    
    for j in range(len(st)+1):
        for word in word_dict:
            wl = len(word)
            if j-wl>=0:           
                dp[j] = dp[j] or (dp[j-wl] and st[j-wl:j] == word)

    return dp[-1]

def word_break(st, word_dict):
    stack = [0]
    cache = set()

    while stack:
        start = stack.pop()
        prev_length = len(stack)

        if start in cache:
            continue

        if start >= len(st):
            return True

        for word in word_dict:
            end = start+len(word)
            sliced = st[start:end]

            if sliced == word and end not in cache:
                stack.append(end)

        if prev_length == len(stack):
            cache.add(start)

    return False

if __name__ == "__main__":
    """
    assert word_break("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", ["aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"]) is False

    assert word_break("leetcode", ["leet", "code"]) is True
    assert word_break("applepenapple", ["apple", "pen"]) is True
    assert word_break("catsandog", ["cats", "dog", "sand", "and", "cat"]) is False
    assert word_break("cats", ["c", "a", "t", "cat"]) is False
    assert word_break("ccacccbcab", ["cc","bb","aa","bc","ac","ca","ba","cb"]) is False 
    assert word_break("acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb", ["abbcbda","cbdaaa","b","dadaaad","dccbbbc","dccadd","ccbdbc","bbca","bacbcdd","a","bacb","cbc","adc","c","cbdbcad","cdbab","db","abbcdbd","bcb","bbdab","aa","bcadb","bacbcb","ca","dbdabdb","ccd","acbb","bdc","acbccd","d","cccdcda","dcbd","cbccacd","ac","cca","aaddc","dccac","ccdc","bbbbcda","ba","adbcadb","dca","abd","bdbb","ddadbad","badb","ab","aaaaa","acba","abbb"]) is True
    assert word_break("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]) is False
    """

    assert optimized("catsandog", ["cats", "dog", "sand", "and", "cat"]) is False
