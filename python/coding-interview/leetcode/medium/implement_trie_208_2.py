class Node:
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors
        self.end = False


class Trie:
    def __init__(self):
        self.head = Node("", {})

    def insert(self, word: str) -> None:
        node = self.head

        idx = 0
        while idx < len(word) and word[idx] in node.neighbors:
            node = node.neighbors[word[idx]]
            idx += 1

        while idx < len(word):
            child = Node(word[idx], {})
            node.neighbors[word[idx]] = child
            idx += 1
            node = child

        node.end = True

    def search(self, word: str) -> bool:
        node = self.head

        idx = 0
        while idx < len(word) and word[idx] in node.neighbors:
            node = node.neighbors[word[idx]]
            idx += 1

        return idx == len(word) and node.end == True

    def startsWith(self, prefix: str) -> bool:
        node = self.head

        idx = 0
        while idx < len(prefix) and prefix[idx] in node.neighbors:
            node = node.neighbors[prefix[idx]]
            idx += 1

        return idx == len(prefix)


if __name__ == "__main__":
    t = Trie()

    t.insert("abc")
    assert t.search("abc") is True
    assert t.search("abd") is False
    assert t.startsWith("ab") is True

    t.insert("abcd")
    assert t.search("abc") is True
    assert t.search("abcd") is True
    assert t.search("abce") is False

    assert t.startsWith("a") is True
    assert t.startsWith("ab") is True
    assert t.startsWith("abc") is True
    assert t.startsWith("abcd") is True

    assert t.startsWith("abz") is False
    assert t.startsWith("abcz") is False
    assert t.startsWith("b") is False

    t.insert("apple")
    assert t.search("apple") is True
    assert t.search("app") is False
    assert t.startsWith("app") is True

    t.insert("app")
    assert t.search("app") is True

    t.insert("zzz")
    assert t.search("zzzz") is False

