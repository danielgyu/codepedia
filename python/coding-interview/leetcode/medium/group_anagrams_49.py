from collections import defaultdict


def solution(strs):
	res = defaultdict(list)

	for s in strs:
		sorted_s = "".join(sorted(s))
		res[sorted_s].append(s)

	return res.values()


solution(["eat", "tea", "tan", "ate", "nat", "bat"])
solution(["a"])
solution([""])
solution(["", ""])
