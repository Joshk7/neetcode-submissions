class TrieNode:

    def __init__(self):
        self.children = {}
        self.ending = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        self.insert(word)

    def search(self, word: str) -> bool:
        return self.dfs(word, self.root)
    
    def insert(self, word):
        node = self.root
        for c in word:
            if not c in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.ending = True
    
    def dfs(self, word, cur):
        node = cur
        for i, c in enumerate(word):
            if not c in node.children:
                if c == '.':
                    for letter in node.children:
                        if self.dfs(word[i + 1:], node.children[letter]):
                            return True
                return False
            node = node.children[c]
        return node.ending
