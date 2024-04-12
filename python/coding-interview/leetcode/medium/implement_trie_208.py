class Node:
    def __init__(self, char, end=False):
        self.char = char
        self.end = end
        self.child = {}

    def __repr__(self):
        return f"node: {self.char}"

class Trie:
    def __init__(self):
        self.root = Node('-')

    def insert(self, word):
        level = self.root
        idx = 0

        while word[idx] in level.child:
            level = level.child[word[idx]]
            idx += 1

        while idx < len(word):
            level.child[word[idx]] = Node(word[idx])
            level = level.child[word[idx]]
            idx += 1

        level.end = True

    def _search(self, word):
        level = self.root
        idx = 0
        while idx < len(word):
            if not word[idx] in level.child:
                return False
            level = level.child[word[idx]]
            idx += 1
        return level

    def search(self, word):
        last_node = self._search(word)
        return True if last_node.end else False

    def starts_with(self, prefix):
        last_node = self._search(prefix)
        return True if last_node else False

if __name__ == "__main__":
    trie = Trie()
    trie.insert('apple')
    print(trie.search('apple'))
    print(trie.search('app'))
    print(trie.starts_with('app'))
