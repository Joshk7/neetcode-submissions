class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for course in range(numCourses)]
        indegree = [0] * numCourses
        for a, b in prerequisites:
            adj[a].append(b)
            indegree[b] += 1

        queue = deque()
        for course in range(numCourses):
            if indegree[course] == 0:
                queue.append(course)
        
        finish = 0
        while queue:
            node = queue.popleft()
            finish += 1
            for nei in adj[node]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    queue.append(nei)
        
        return finish == numCourses
        

