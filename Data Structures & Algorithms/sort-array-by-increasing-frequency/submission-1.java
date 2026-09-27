class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int[] sorted = Arrays.stream(nums)
        .boxed()
        .sorted((a, b) -> {
            int x = counts.get(a), y = counts.get(b);
            if (x == y) {
                return b - a;
            } else {
                return x - y;
            }
        })
        .mapToInt(Integer::intValue)
        .toArray();
        
        return sorted;
    }
}