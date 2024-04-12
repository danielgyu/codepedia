from collections import deque


class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

    def __repr__(self):
        return f"node:{self.val}"


def clone_graph(node):
    if not node:
        return

    map = {}
    visited = set()

    q = deque([node])
    while q:
        n = q.popleft()
        if n.val in visited:
            continue

        print(f"{n.val=}")
        if n.val not in map:
            map[n.val] = Node(n.val) 

        for nb in n.neighbors:
            if nb.val not in map:
                map[nb.val] = Node(nb.val)

            map[n.val].neighbors.append(map[nb.val])
            q.append(nb)

        visited.add(n.val)

    for val, n in map.items():
        print(f"node {val} has neighbors {n.neighbors}")

    return map[1]

if __name__ == "__main__":
    n1, n2, n3, n4 = Node(1), Node(2), Node(3), Node(4)
    n1.neighbors = [n2, n4]
    n3.neighbors = [n2, n4]
    n2.neighbors = [n1, n3]
    n4.neighbors = [n1, n3]
    head = clone_graph(n1)
    breakpoint()
