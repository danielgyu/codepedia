def solution(intervals, new_interval):
	i, length = 0, len(intervals)

	res = []
	while i < length:
		# no correlation
		if new_interval[0] > intervals[i][1] or new_interval[1] < intervals[i][0]:
			res.append(intervals[i])

		# in between
		if ((i >= 0 and i < length) and 
			new_interval[0] > intervals[i][1] and
			new_interval[1] < intervals[i+1][0]):
			res.append(new_interval)

		# merge possibility
		start = min(intervals[i][0], new_interval[0])
		while new_interval[1] > intervals[i][1]:
			i += 1
		end = intervals[i][1]
		res.append([start, end])

		i += 1

	print(f"res: {res}")
	return res


solution([[1,3],[6,9]], [4,5])
solution([[1,3],[6,9]], [2,5])
