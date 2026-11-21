# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        def rec(node: Optional[ListNode], i) -> Optional[ListNode]:
            if not node:
                return None
            
            node.next = rec(node.next, i)
            i[0] -= 1
            if i[0] == 0:
                return node.next
            return node
        
        return rec(head, [n])