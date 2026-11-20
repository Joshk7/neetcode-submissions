# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        node = dummy
        one = list1
        two = list2

        while one or two:
            if not one:
                node.next = two
                two = None
            elif not two:
                node.next = one
                one = None
            elif one.val < two.val:
                node.next = one
                one = one.next
                node = node.next
            else:
                node.next = two
                two = two.next
                node = node.next
        
        return dummy.next