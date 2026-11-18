class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}

        for num in nums:
            count[num] = 1 + count.get(num, 0)
        
        arr = sorted([(count, num) for num, count in count.items()])
        answer = []
        while len(answer) < k:
            answer.append(arr.pop()[1])
        return answer