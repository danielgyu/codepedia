def num_decodings(s):
    if s[0] == "0":
        return 0

    cache = {}

    def decode(idx, st):
        if not 1 <= int(st) <= 26:
            return 0

        if idx == len(s)-1:
            return 1

        if (idx > len(s)-2):
            return 0

        key = (idx,st)
        if key in cache:
            return cache[key]

        added = decode(idx+1, s[idx+1]) + decode(idx+1, st+s[idx+1])
        cache[key] = added
        return added

    
    return decode(0, s[0])


if __name__ == "__main__":
    print(num_decodings("12"))
    print(num_decodings("226"))
    print(num_decodings("06"))
    print(num_decodings("9"))
    print(num_decodings("1111"))
    print(num_decodings("11111111111111111111"))
    print(num_decodings("11111111111111111111111111111111111111"))
    print(num_decodings("111111111111111111111111111111111111111111111"))
