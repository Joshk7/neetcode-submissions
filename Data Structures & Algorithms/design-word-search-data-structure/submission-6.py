class TrieNode:

    def __init__(self):
        self.children = {}
        self.ending = False


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.ending = True

    def search_with_wildcard(self, word: str) -> bool:
        return self._dfs(word, self.root)

    def _dfs(self, word: str, cur: TrieNode) -> bool:
        node = cur
        for i, c in enumerate(word):
            if c not in node.children:
                if c == '.':
                    for child in node.children.values():
                        if self._dfs(word[i + 1:], child):
                            return True
                return False
            node = node.children[c]
        return node.ending


class WordDictionary:

    def __init__(self):
        self.trie = Trie()

    def addWord(self, word: str) -> None:
        self.trie.insert(word)

    def search(self, word: str) -> bool:
        return self.trie.search_with_wildcard(word)