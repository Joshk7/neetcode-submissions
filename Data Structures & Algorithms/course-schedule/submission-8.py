class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for course in range(numCourses)]
        for a, b in prerequisites:
            adj[a].append(b)
        seen = set()

        def dfs(node):
            if node in seen:
                return False
            
            seen.add(node)
            for nei in adj[node]:
                if not dfs(nei):
                    return False
            seen.remove(node)
            adj[node].clear()
            return True
        
        for course in range(numCourses):
            if not dfs(course):
                return False
        return True

