def numDecodings(s):
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    num_map = {str(n):a for n, a in zip(range(1, 27), alphabet)}
    cache = {}

    def dfs(left, right):
        if (left, right) in cache:
            return cache[(left,right)]

        if right > len(s) or s[left:right] not in num_map:
            return 0

        if right == len(s):
            return 1

        first = dfs(right, right+1)
        second = dfs(right, right+2)
        cache[(left, right)] = first + second

        return first + second

    return dfs(0, 1) + dfs(0, 2)


if __name__ == "__main__":
    #print(f"{numDecodings('12')=}")
    #print(f"{numDecodings('226')=}")
    #print(f"{numDecodings('06')=}")
    #print(f"{numDecodings('2101')=}")
    print(f"{numDecodings('11111111111111')=}")
