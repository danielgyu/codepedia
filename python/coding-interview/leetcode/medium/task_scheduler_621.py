from collections import Counter, deque
from heapq import heapify, heappush, heappop


def solution(tasks, n):
    COUNT, IDX, cur_idx = 0, 1, 1

    counter = Counter(tasks)
    heapify(heap := [[-c, cur_idx] for c in counter.values()])
    queue = deque()

    #print(f"begin: {heap=} // {queue=}")
    while heap or queue:
        if queue and cur_idx > queue[0][IDX]:
            heappush(heap, queue.popleft())

        if heap:
            t = heappop(heap)
            t[COUNT] += 1
            if t[COUNT] < 0:
                t[IDX] = cur_idx + n
                queue.append(t)

        #print(f"{cur_idx=} // {heap=} // {queue=}")
        cur_idx += 1

    return cur_idx-1


if __name__ == "__main__":
    print(solution(["A", "A", "A", "B", "B", "B"], 2))
    print(solution(["A", "A", "A", "B", "B", "B"], 0))
    print(solution(["A"]*6 + ["B", "C", "D", "E", "F", "G"], 2))
    print(solution(["A", "A", "A", "B", "B", "B", "C", "C", "C", "D", "D", "E"], 2))
