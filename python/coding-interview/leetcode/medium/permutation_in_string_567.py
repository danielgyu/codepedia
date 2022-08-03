from collections import Counter

def is_match(d1, d2):
    for k in d2.keys():
        if k not in d1 or d2[k] != d1[k]:
            return False
    return True

def solution_0728(s1, s2):
    for idx in range(len(s2)-len(s1)+1):
        s1_counter = Counter(s1)
        s2_counter = Counter(s2[idx:idx+len(s1)])
        if is_match(s1_counter, s2_counter):
            return True

    return False


if __name__ == "__main__":
    print(solution_0728("ab", "eidbaooo"))
    print(solution_0728("adc", "dcda"))
    print(solution_0728("ab", "eidboaoo"))
