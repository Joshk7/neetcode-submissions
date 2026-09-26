class Solution {
    private Map<Integer, Integer> cache;

    public int minOperations(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int answer = 0;
        cache = new HashMap<>();
        for (int cnt : counts.values()) {
            int operations = dfs(cnt);
            if (operations == Integer.MAX_VALUE) {
                return -1;
            }
            answer += operations;
        }

        return answer;
    }

    private int dfs(int count) {
        if (count < 0) {
            return Integer.MAX_VALUE;
        }

        if (count == 0) {
            return 0;
        }

        if (cache.containsKey(count)) {
            return cache.get(count);
        }

        int operations = Math.min(dfs(count - 2), dfs(count - 3));
        int result = operations == Integer.MAX_VALUE ? operations : 1 + operations;
        cache.put(count, result);
        return result;
    }
}