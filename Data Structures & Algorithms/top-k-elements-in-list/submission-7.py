class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        maxFreq = 0
        counts = {}
        for num in nums:
            counts[num] = counts.get(num, 0) + 1
            maxFreq = max(maxFreq, counts[num])
        
        print(maxFreq)
        frequencies = [list() for _ in range(maxFreq)]
        for (num, count) in counts.items():
            frequencies[count - 1].append(num)
        print(frequencies)
        answer = [0] * k
        index = 0
        frequency = maxFreq - 1
        while index < k and frequency >= 0:
            if frequencies[frequency]:
                answer[index] = frequencies[frequency].pop()
                index += 1
            else:
                frequency -= 1
            
        return answer
        