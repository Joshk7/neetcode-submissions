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
            cur = lists[i]
            node.next = cur
            node = node.next
            if cur.next:
                heapq.heappush(heap, (cur.next.val, i))
                lists[i] = cur.next

        return dummy.next
