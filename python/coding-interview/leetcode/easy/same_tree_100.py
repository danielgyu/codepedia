class Node:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def bfs(node, res):
    if node is None:
        res.append(None)
        return res

    res.append(node.val)
    bfs(node.left, res)
    bfs(node.right, res)

    return res


def solution(ppp, qqq):
    left = bfs(ppp, [])
    right = bfs(qqq, [])
    return left == right


def test_1():
    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(1)
    n1.left = n2
    n1.right = n3

    nn1 = Node(1)
    nn2 = Node(2)
    nn3 = Node(1)
    nn1.left = nn2
    nn1.right = nn3

    print(solution(n1, nn1))


def test_2():
    n1 = Node(1)
    n2 = Node(2)
    n1.left = n2

    nn1 = Node(1)
    nn2 = Node(2)
    nn1.right = nn2

    print(solution(n1, nn1))

if __name__ == "__main__":
    test_1()
    test_2()
