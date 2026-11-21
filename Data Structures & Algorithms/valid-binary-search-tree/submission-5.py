# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def isValid(node: Optional[TreeNode], minimum: int, maximum: int) -> bool:
            if not node:
                return True
            
            if node.val <= minimum or maximum <= node.val:
                return False
            
            left = isValid(node.left, minimum, node.val)
            right = isValid(node.right, node.val, maximum)
            return left and right
        return isValid(root, float('-inf'), float('inf'))