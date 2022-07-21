import heapq

def solution(nums):
    if not nums:
        return 0

    longest, current = 1, 1
    heapq.heapify(nums)

    before = heapq.heappop(nums)
    while nums:
        after = heapq.heappop(nums)
        # print(f"{before=}, {after=}")

        if after - before == 1:
            current += 1
        elif after - before > 1:
            longest = max(longest, current)
            current = 1

        before = after

    return max(longest, current)

def solution2(nums):
    if not nums:
        return 0

    num_set = set(n for n in nums)
    seen = set()
    longest = 1

    for n in nums:
        if n in seen:
            continue

        current = 1

        left = n - 1
        while left in num_set:
            seen.add(left)
            left -= 1
            current += 1
        
        right = n + 1
        while right in num_set:
            seen.add(right)
            right += 1
            current += 1

        longest = max(longest, current)

    return longest


if __name__ == "__main__":
    print(solution([100, 4, 200, 1, 3, 2]))
    print(solution([0, 3, 7, 2, 5, 8, 4, 6, 0, 1]))
    print(solution([]))
    print(solution([0]))
    print(solution([1, 2, 3, 100, 101, 102, 103]))
    print("---")
    print(solution2([100, 4, 200, 1, 3, 2]))
    print(solution2([0, 3, 7, 2, 5, 8, 4, 6, 0, 1]))
    print(solution2([]))
    print(solution2([0]))
    print(solution2([1, 2, 3, 100, 101, 102, 103]))
