import heapq

def solution(stones):
    if len(stones) == 1:
        return stones[0]

    heapq.heapify(stones := [s*-1 for s in stones])

    while len(stones) > 1:
        print(stones)
        y = heapq.heappop(stones)
        x = heapq.heappop(stones)

        if x != y:
            heapq.heappush(stones, (y-x))

    return stones[0] * -1 if stones else 0


if __name__ == "__main__":
    print(solution([2, 7, 4, 1, 8, 1]))
    print(solution([1]))
    print(solution([3, 7, 2]))
