from collections import defaultdict
import heapq

def solution(nums, k):
    freq_to_num = defaultdict(set)
    num_to_freq = defaultdict(int)

    for n in nums:
        before = num_to_freq[n]
        if before != 0:
            freq_to_num[before].remove(n)

        freq_to_num[before+1].add(n)
        num_to_freq[n] += 1

    max_freqs = list()
    heapq.heapify(max_freqs)
    for freq in freq_to_num.keys():
        heapq.heappush(max_freqs, freq * -1)
    
    res = set()
    while len(res) < k:
        popped = heapq.heappop(max_freqs) * -1
        popped_nums = freq_to_num[popped]
        res.update(popped_nums)

    return list(res)

def suggested(nums, k):
    count = dict()
    freq = [[] for _ in range(len(nums)+1)]

    for n in nums:
        count[n] = count.get(n, 0) + 1

    for n, c in count.items():
        freq[c].append(n)

    breakpoint()

if __name__ == "__main__":
    # print(solution([1,1,2,4,1,2,3], 2))
    # print(solution([1], 1))

    print(suggested([1,1,2,4,1,2,3], 2))
    # print(suggested([1], 1))
