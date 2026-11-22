class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        
        queue = deque([0])
        seen = [False] * (amount + 1)
        steps = 0
        while queue:
            steps += 1
            size = len(queue)
            for _ in range(size):
                total = queue.popleft()
                for coin in coins:
                    if total + coin == amount:
                        return steps
                    if total + coin < amount and not seen[total + coin]:
                        seen[total + coin] = True
                        queue.append(total + coin)
        
        return -1