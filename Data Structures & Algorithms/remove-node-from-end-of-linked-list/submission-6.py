# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def rec(self, head):
        if not head:
            return None
        
        head.next = self.rec(head.next)
        self.n -= 1
        if self.n == 0:
            return head.next
        return head

    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        self.n = n
        return self.rec(head)
        
        