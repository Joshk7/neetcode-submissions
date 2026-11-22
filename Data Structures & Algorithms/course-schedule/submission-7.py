class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0] * numCourses
        adj = [[] for _ in range(numCourses)]

        for a, b in prerequisites:
            indegree[b] += 1
            adj[a].append(b)
        
        queue = deque()
        for i, d in enumerate(indegree):
            if d == 0:
                queue.append(i)
        
        while queue:
            a = queue.popleft()
            for b in adj[a]:
                indegree[b] -= 1
                if indegree[b] == 0:
                    queue.append(b)

        for degree in indegree:
            if degree > 0:
                return False
        return True
                
