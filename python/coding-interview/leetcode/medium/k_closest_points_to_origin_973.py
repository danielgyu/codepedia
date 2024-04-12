from math import sqrt
from heapq import heapify, heappop, heappush


def get_euclidean_distance(x, y):
    return sqrt(((x-0)**2) + ((y-0)**2))


def solution(points, k):
    heapify(res:=[]) 

    for idx, point in enumerate(points):
        distance = get_euclidean_distance(point[0], point[1])
        heappush(res, (distance*-1, idx))

        if len(res) > k:
            heappop(res)

    return [points[r[1]] for r in res]


if __name__ == "__main__":
    print(solution([[1, 3], [-2, 2]], 1))
    print(solution([[3, 3], [5, -1], [-2, 4]], 2))
