# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        parents = {}
        def dfs(node: TreeNode) -> None:
            if not node:
                return
            if node.left:
                parents[node.left] = node
            if node.right:
                parents[node.right] = node
            dfs(node.left)
            dfs(node.right)
        
        dfs(root)

        visited = set([p, q])
        queue = deque([p, q])
        while queue:
            node = queue.popleft()
            if node in parents and parents[node]:
                if parents[node] in visited:
                    return parents[node]
                visited.add(parents[node])
                queue.append(parents[node])
        return TreeNode(-1)