# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for (i, l) in enumerate(lists):
            if not l:
                continue
            heapq.heappush(heap, (l.val, i))
        
        dummy = ListNode()
        node = dummy

        while heap:
            val, i = heapq.heappop(heap)
            node.next = lists[i]
            node = node.next
            if lists[i].next:
                heapq.heappush(heap, (lists[i].next.val, i))
                lists[i] = lists[i].next

        return dummy.next
