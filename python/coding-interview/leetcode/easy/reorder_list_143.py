class Node:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next


def print_node(head):
    while head is not None:
        print(head.val)
        head = head.next


def solution(head):
    idx, mapper = 0, dict()
    temp = head
    while temp is not None:
        mapper[idx] = temp
        temp = temp.next
        idx += 1
    
    start, end = 0, len(mapper)-1
    while start <= end:
        mapper[start].next = mapper[end]
        mapper[end].next = mapper[start+1]

        start, end = start+1, end-1

    mapper[(len(mapper)//2)].next = None
    print_node(head)
    return head

if __name__ == "__main__":
    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node4 = Node(4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    solution(node1)
    print('---')
    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node4 = Node(4)
    node5 = Node(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    solution(node1)

