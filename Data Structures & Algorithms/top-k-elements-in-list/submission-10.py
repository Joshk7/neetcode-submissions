class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}

        for num in nums:
            count[num] = 1 + count.get(num, 0)
        
        sort = sorted([(count, num) for num, count in count.items()])
        answer = []
        for i in range(k):
            answer.append(sort[len(sort) - i - 1][1])
        return answer