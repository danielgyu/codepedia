mapper = {
    "2": "abc",
    "3": "def",
    "4": "ghi",
    "5": "jkl",
    "6": "mno",
    "7": "qprs",
    "8": "tuv",
    "9": "wxyz",
}

def solution(digits):
    res = []

    def bt(idx, s):
        if idx == len(digits):
            res.append(s)
            return

        for c in mapper[digits[idx]]:
            bt(idx+1, s+c)

    bt(0, "")
    return res


if __name__ == "__main__":
    print(solution("23"))
