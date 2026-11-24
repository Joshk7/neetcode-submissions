class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        previous = intervals[0]
        answer = []
        for i in range(1, len(intervals)):
            current = intervals[i]
            if previous[1] >= current[0]:
                previous[0] = min(previous[0], current[0])
                previous[1] = max(previous[1], current[1])
            else:
                answer.append(previous)
                previous = current
        answer.append(previous)

        return answer