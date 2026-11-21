# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        node = root
        minimum = min(p.val, q.val)
        maximum = max(p.val, q.val)
        while node:
            if node.val < minimum:
                node = node.right
            elif node.val > maximum:
                node = node.left
            else:
                break
        
        return node