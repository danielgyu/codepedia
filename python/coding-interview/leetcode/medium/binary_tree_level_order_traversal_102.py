from collections import deque


class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def level_order(root):
    q = deque()
    q.append((0, root))

    nodes = []

    while q:
        level, node = q.popleft()
        if len(nodes)-1 < level:
            nodes.append([])

        nodes[level].append(node.val)

        if node.left:
            q.append((level+1, node.left))
        if node.right:
            q.append((level+1, node.right))
        

    return nodes


if __name__ == "__main__":
    n3, n9, n20, n15, n7 = Node(3), Node(9), Node(20), Node(15), Node(7)
    n3.left, n3.right = n9, n20
    n20.left, n20.right = n15, n7

    print(level_order(n3))
