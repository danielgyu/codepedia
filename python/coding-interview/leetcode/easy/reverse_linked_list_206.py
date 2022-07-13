class Node:
    def __init__(self, val=0, next=None):
        self.val=val
        self.next=next

    def __repr__(self):
        return f"node val={self.val}"
    
def recurse(node, last):
    if node.next is None:
        return node

    last = recurse(node.next, None)
    node.next.next = node
    return last


def reverse(head):
    last = recurse(head, None)
    head.next = None
    return last


if __name__ == "__main__":
    n1 = Node(1)
    n2 = Node(2)
    n1.next = n2
    n3 = Node(3)
    n2.next = n3
    n4 = Node(4)
    n3.next = n4
    n5 = Node(5)
    n4.next = n5
    print(reverse(n1))

    nn1 = Node(1)
    nn2 = Node(2)
    nn1.next = nn2
    print(reverse(nn1))
