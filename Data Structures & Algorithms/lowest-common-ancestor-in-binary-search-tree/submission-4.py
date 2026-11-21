# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        def rec(node: TreeNode, minimum: int, maximum: int) -> TreeNode:
            if not node:
                return None
            
            if node.val < minimum:
                return rec(node.right, minimum, maximum)
            elif node.val > maximum:
                return rec(node.left, minimum, maximum)
            else:
                return node
        
        return rec(root, min(p.val, q.val), max(p.val, q.val))