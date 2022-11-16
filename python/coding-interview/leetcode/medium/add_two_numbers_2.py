class Node:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next


def print_node(head):
    while head is not None:
        print(head.val)
        head = head.next


def solution(l1, l2):
    carry = 0
    sum_node = Node(0)
    head = sum_node
    while l1 is not None or l2 is not None:
        if l1 is None:
            l1 = Node(0)
        if l2 is None:
            l2 = Node(0)

        s = (l1.val%10) + (l2.val%10) + carry
        if s > 9:
            carry = 1
        else:
            carry = 0

        sum_node.next = Node(s%10)
        
        l1 = l1.next
        l2 = l2.next
        sum_node = sum_node.next

    if carry > 0:
        sum_node.next = Node(carry)

    print_node(head.next)
    return head.next


if __name__ == "__main__":
    n1, n2, n3 = Node(2), Node(4), Node(5)
    n4, n5, n6 = Node(5), Node(6), Node(4)
    n1.next, n2.next = n2, n3
    n4.next, n5.next = n5, n6
    solution(n1, n4)

