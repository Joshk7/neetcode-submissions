class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        profit = 0
        for i in range(n):
            for j in range(i + 1, n):
                profit = max(profit, prices[j] - prices[i])
        return profit