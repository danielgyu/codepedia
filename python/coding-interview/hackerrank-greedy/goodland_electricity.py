def solution(k, arr):
    size = len(arr)
    start, last = 0, -1
    total = 0

    while start < size:
        # -1 because the it's 'less than'
        # size-1 because we don't want to go over
        furthest = min(start+k-1, size-1)

        for i in range(furthest, last, -1):
            if arr[i]:
                total += 1
                start = i+k
                last = i
                break
        else:
            return -1

    return total

def solution2(k, arr):
    start, leftmost = 0, -1

    count = 0
    while start < len(arr):
        rightmost = min(start+k-1, len(arr)-1)

        for i in range(rightmost, leftmost, -1):
            if arr[i]:
                start = i+k
                leftmost = i
                count += 1
                break
        else:
            return -1

    return count


# assert solution(3, [0, 1, 1, 1, 0, 0, 0]) == -1
# assert solution2(3, [0, 1, 1, 1, 0, 0, 0]) == -1

# assert solution(2, [0, 1, 1, 1, 1, 0]) == 2
# assert solution2(2, [0, 1, 1, 1, 1, 0]) == 2

assert solution2(3, [0, 1, 0, 0, 0, 1, 1, 1, 1, 1]) == 3
