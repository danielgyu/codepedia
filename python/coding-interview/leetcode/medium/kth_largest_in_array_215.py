from heapq import heapify, heappop


def solution(nums, k):
    nums = [n*-1 for n in nums]
    heapify(nums)

    for _ in range(k):
        num = heappop(nums)

    return num*-1


if __name__== "__main__":
    print(solution([3, 2, 1, 5, 6, 4], 2))
    print(solution([3, 2, 3, 1, 2, 4, 5, 5, 6], 4))
