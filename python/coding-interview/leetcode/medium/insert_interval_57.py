def solution(intervals, new_interval):
	res = []
	for i in range(len(intervals)):
		if new_interval[1] < intervals[i][0]:
			res.append(new_interval)
			return res + intervals[i:]
		elif new_interval[0] > intervals[i][1]:
			res.append(intervals[i])
		else:
			start = min(new_interval[0], intervals[i][0])
			end = max(new_interval[1], intervals[i][1])
			new_interval = [start, end]
	
	res.append(new_interval)
	return res


solution([[1,2],[3,5],[6,7],[8,10],[12,16]], [4,8])
assert solution([[1,3],[6,9]], [4,5]) == [[1,3], [4,5], [6,9]]
assert solution([[1,3],[6,9]], [2,5]) == [[1,5], [6,9]]
assert solution([[4,5],[8,10]], [11,19]) == [[4,5], [8, 10], [11,19]]
assert solution([[8,10],[13,15]], [1,3]) == [[1,3], [8,10], [13,15]]
assert solution([], [5,7]) == [[5,7]]
assert solution([[1,5]], [2,7]) == [[1,7]]
