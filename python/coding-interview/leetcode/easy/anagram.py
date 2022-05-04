from collections import Counter


def solution(s, t):
    c1 = Counter(s)
    c2 = Counter(t)

    for key in c1:
        if c1.get(key) != c2.get(key):
            return False

    return True

assert solution("anagram", "nagaram") is True
assert solution("rat", "car") is False
