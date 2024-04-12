class Node:
    def __init__(self, key, val, prev=None, nxt=None):
        self.key = key
        self.val = val
        self.prev = prev
        self.nxt = nxt

    def __repr__(self):
        return f"Node({self.key}:{self.val})"

class Cache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}
        self.initialize_ends()

    def initialize_ends(self):
        self.tail = Node(-1, 100)
        self.head = Node(-1, 999)
        self.tail.nxt = self.head
        self.head.prev = self.tail

    def _evict_node(self, node):
        prev, nxt = node.prev, node.nxt
        prev.nxt, nxt.prev = nxt, prev

    def _put_to_most_recent(self, node):
        prev, nxt = self.head.prev, self.head
        prev.nxt = nxt.prev = node
        node.nxt, node.prev = nxt, prev

    def get(self, key):
        if self.cache.get(key):
            self._evict_node(self.cache[key])
            self._put_to_most_recent(self.cache[key])
            return self.cache[key].val
        return -1

    def put(self, key, value):
        if key in self.cache:
            self._evict_node(self.cache[key])
        self.cache[key] = Node(key, value)
        self._put_to_most_recent(self.cache[key])

        if len(self.cache) > self.capacity:
            lru_node = self.tail.nxt
            self._evict_node(lru_node)
            del self.cache[lru_node.key]

if __name__ == "__main__":
    lru3 = Cache(2)
    lru3.put(1, 1)
    lru3.put(2, 2)
    print(lru3.get(1))
    lru3.put(3, 3)
    print(lru3.get(2))
    lru3.put(4, 4)
    print(lru3.get(1))
    print(lru3.get(3))
    print(lru3.get(4))  # 1, -1, 3, 4

    print("@@@@@@@@")

    lru = Cache(2)
    lru.put(2, 1)
    lru.put(1, 1)
    lru.put(2, 3)
    lru.put(4, 1)
    print(lru.get(1))
    print(lru.get(2))  # -1, 3

    print("@@@@@@@@")

    lru2 = Cache(2)
    print(lru2.get(2))
    lru2.put(2, 6)
    print(lru2.get(1))
    lru2.put(1, 5)
    lru2.put(1, 2)
    print(lru2.get(1))
    print(lru2.get(2))  # -1, -1, 2, 6
