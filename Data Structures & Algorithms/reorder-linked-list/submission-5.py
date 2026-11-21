# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        l1 = head.next
        l2 = head
        while l1 and l1.next:
            l1 = l1.next.next
            l2 = l2.next
        
        node = l2.next
        prev = l2.next = None
        while node:
            tmp = node.next
            node.next = prev
            prev = node
            node = tmp
        
        l2 = prev
        l1 = head
        while l2:
            t1, t2 = l1.next, l2.next
            l1.next = l2
            l2.next = t1
            l1, l2 = t1, t2
