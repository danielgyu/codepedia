import math

def solution(piles, h):
    l, r = 1, max(piles)
    res = r

    while l <= r:
        k = (l+r) // 2
        hours = 0
        for p in piles:
            hours += math.ceil(p/k)

        if hours <= h:
            res = min(res, k)
            r = k-1
        else:
            l = k+1

    return res

if __name__ == "__main__":
    print(solution([3, 6, 7, 11], 8))
    print(solution([30, 11, 23, 4, 20], 5))
    print(solution([30, 11, 23, 4, 20], 6))
