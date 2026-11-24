class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses
        for a, b in prerequisites:
            adj[b].append(a)
            indegree[a] += 1
        
        taken = 0
        queue = deque()
        seen = [False] * numCourses
        for course in range(numCourses):
            if indegree[course] == 0:
                queue.append(course)
                seen[course] = True
                
        taken = 0
        while queue:
            node = queue.popleft()
            taken += 1
            for child in adj[node]:
                indegree[child] -= 1
                if indegree[child] == 0:
                    # if seen[child]:
                    #     return False
                    # seen[child] = True
                    queue.append(child)

        return taken == numCourses

                
                
