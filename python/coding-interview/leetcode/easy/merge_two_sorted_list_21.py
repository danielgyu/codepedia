class Node:
    def __init__(self, val=0, next=None):
        self.val=val
        self.next=next


def print_node(node):
    while node is not None:
        print(node.val)
        node = node.next


def solution(node1, node2):
    head = Node()
    node = head
    while node1 is not None and node2 is not None:
        if node1.val < node2.val:
            node.next = node1
            node1 = node1.next
        else:
            node.next = node2
            node2 = node2.next
        node = node.next

    while node1 is not None:
        node.next = node1
        node1 = node1.next
        node = node.next
    
    while node2 is not None:
        node.next = node2
        node2 = node2.next
        node = node.next


    return head.next


if __name__ == "__main__":
    """
    l1, n2, n3 = Node(1), Node(2), Node(3)
    l1.next = n2
    n2.next = n3

    l2, n2, n3, n4 = Node(1), Node(3), Node(4), Node(5)
    l2.next = n2
    n2.next = n3
    n3.next = n4

    head = solution(l1, l2)
    print_node(head)
    """

    print_node(solution(None, None))
