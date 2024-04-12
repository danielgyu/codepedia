class Node:
    def __init__(self, val, next=None, random=None):
        self.val=val
        self.next=next
        self.random=random

def print_node(head):
    while head is not None:
        print(f"{head.val=}")
        if head.next:
            print(head.next.val)
        if head.random:
            print(head.random.val)
        print("---")

        head = head.next

def solution(head):
    node_list = []
    copy_list = []
    temp = head
    while temp is not None:
        node_list.append(temp)
        copy_list.append(Node(temp.val))
        temp = temp.next

    for i in range(len(node_list)):
        if i < len(node_list)-1:
            copy_list[i].next = copy_list[i+1]

        random_node = node_list[i].random
        if random_node:
            random_idx = node_list.index(random_node)
            copy_list[i].random = copy_list[random_idx]

    print_node(copy_list[0])
    return copy_list[0]


if __name__ == "__main__":
    n7 = Node(7)
    n13 = Node(13)
    n11 = Node(11)
    n10 = Node(10)
    n1 = Node(1)
    n7.next, n7.random = n13, None
    n13.next, n13.random = n11, n7
    n11.next, n11.random = n10, n1
    n10.next, n10.random = n1, n11
    n1.next, n1.random = None, n7
    solution(n7)
