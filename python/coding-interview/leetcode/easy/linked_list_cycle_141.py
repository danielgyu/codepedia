class Node:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next

def solution(head):
    container = dict()
    while head is not None:
        if container.get(head.val):
            if head in container[head.val]:
                return True
            container[head.val].append(head)
        else:
            container[head.val] = [head]

        head = head.next

    return False


if __name__ == "__main__":
    node1 = Node(3)
    node2 = Node(2)
    node3 = Node(0)
    node4 = Node(-4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    #node4.next = node2

    print(solution(node1))
