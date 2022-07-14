from heapq import heapify, heappop, heappush


class KthLargest:
    def __init__(self, k, nums):
        self.k = k
        self.heap = self.convert(nums)

    def convert(self, nums):
        heapify(nums)
        while len(nums) > self.k:
            heappop(nums)
        return nums

    def add(self, val):
        heappush(self.heap, val)
        heappop(self.heap)
        return self.heap[0]

if __name__ == "__main__":
    k = KthLargest(3, [4, 5, 8, 2])
    print(k.add(3))
    print(k.add(5))  
    print(k.add(10))
    print(k.add(9))
    print(k.add(4))

    k2 = KthLargest(2, [3, 4, 2])
