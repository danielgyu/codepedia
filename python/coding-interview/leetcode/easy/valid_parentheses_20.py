matches = {
	")": "(",
	"}": "{",
	"]": "[",
}


def solution(s):
	stack = list()
	for v in s:
		if v in matches:
			if not stack or stack[-1] != matches[v]:
				return False 
			stack.pop()
		else:
			stack.append(v)

	return not stack


print(solution("()"))
print(solution("()[]{}"))
print(solution("(())"))
print(solution("((})"))
print(solution("())"))
