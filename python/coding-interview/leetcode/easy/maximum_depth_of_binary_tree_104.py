class Node:
	def __init__(self, val=0, left=None, right=None):
		self.val=val
		self.left=left
		self.right=right


def dfs(node, depth):
	if node is None:
		print(depth)
		return depth
	
	depth += 1
	left = max(depth, dfs(node.left, depth))
	right = max(depth, dfs(node.right, depth))

	return max(left, right) 


def solution(root):
	return dfs(root, 0)


def test1():
	node3 = Node(3)
	node9 = Node(9)
	node20 = Node(20)
	node15 = Node(15)
	node7 = Node(7)
	node3.left = node9
	node3.right = node20
	node20.left = node15
	node20.right = node7

	print(solution(node3))

test1()
