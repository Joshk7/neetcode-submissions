"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        adj = {}
        def clone(node: Optional['Node']) -> Optional['Node']:
            if not node:
                return None

            if node in adj:
                return adj[node]

            adj[node] = Node(node.val)       
            for nei in node.neighbors:
                adj[node].neighbors.append(clone(nei))

            return adj[node]

        return clone(node)
