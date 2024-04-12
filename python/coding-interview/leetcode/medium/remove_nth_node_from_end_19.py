class Node:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next


def print_node(node):
    while node is not None:
        print(node.val)
        node = node.next


def solution(head, n):
    node_list = []

    cur = head
    while cur is not None:
        node_list.append(cur)
        cur = cur.next

    total = len(node_list)
    if total == 1:
        return None

    if n == total:  # first
        head = node_list[1]
    elif n == 1:  # last
        node_list[-2].next = None
    else:
        node_list[total-n-1].next = node_list[total-n+1]

    print_node(head)
    return head


if __name__ == "__main__":
    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node4 = Node(4)
    node5 = Node(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    solution(node1, 2)
    print('---')
    node1b = Node(1)
    node2b = Node(2)
    node1b.next = node2b
    solution(node1b, 1)
    print('---')
    node1c = Node(1)
    solution(node1c, 1)
    print('---')
    node1d = Node(1)
    node2d = Node(2)
    node1d.next = node2d
    solution(node1d, 2)
