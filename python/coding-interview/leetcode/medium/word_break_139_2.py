from collections import deque

def word_break(s, wordDict):
    found = [0 for _ in range(len(s))]
    indices = deque([0])

    while indices:
        idx = indices.popleft()
        for word in wordDict:
            target = idx+len(word)
            if word == s[idx:target] and found[target-1] == 0:
                found[target-1] = 1
                indices.append(target)

    return found[-1] == 1


if __name__ == "__main__":
    print(word_break("leetcode", ["leet", "code"]))
    print(word_break("applepenapple", ["apple", "pen"]))
    print(word_break("catsandog", ["cats", "dog", "sand", "and", "cat"]))
    print(word_break("catdogtig", ["cat", "dog", "ti", "catdog", "ca", "tdogt", "ig"]))
    print(word_break("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]))
