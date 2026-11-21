class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.ending = False

class PrefixTree:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for c in word:
            if not node.children[ord(c) - ord('a')]:
                node.children[ord(c) - ord('a')] = TrieNode()
            node = node.children[ord(c) - ord('a')]
        node.ending = True

    def search(self, word: str) -> bool:
        node = self.root
        for c in word:
            if node.children[ord(c) - ord('a')] == None:
                return False
            node = node.children[ord(c) - ord('a')]
        return node.ending

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for c in prefix:
            if node.children[ord(c) - ord('a')] == None:
                return False
            node = node.children[ord(c) - ord('a')]
        return True
        