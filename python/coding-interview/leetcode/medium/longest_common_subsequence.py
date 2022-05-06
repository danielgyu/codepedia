def solution_recursion(text1, text2):
	def recurse(i, j):
		if i >= len(text1) or j >= len(text2):
			return 0
		elif text1[i] == text2[j]:
			return 1 + recurse(i+1, j+1)
		else:
			return max(recurse(i+1, j), recurse(i, j+1))

	return recurse(0, 0)


def solution(text1, text2):
	table = [[0 for _ in range(len(text2)+1)] for _ in range(len(text1)+1)]

	for i in range(1, len(text1)+1):
		for j in range(1, len(text2)+1):
			a1, a2 = text1[i-1], text2[j-1]
			if a1 == a2:
				table[i][j] = 1 + table[i-1][j-1]
			else:
				table[i][j] = max(table[i-1][j], table[i][j-1])
	
	return table[i][j]


	
assert solution_recursion("abcde", "ace") == 3
assert solution_recursion("abc", "abc") == 3
assert solution_recursion("abc", "def") == 0
assert solution_recursion("efg", "abesfh") == 2

assert solution("abcde", "ace") == 3
assert solution("abc", "abc") == 3
assert solution("abc", "def") == 0
assert solution("efg", "abesfh") == 2
