class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{
                    Math.min(i + 1, map.get(target - numbers[i]) + 1), 
                    Math.max(i + 1, map.get(target - numbers[i]) + 1)};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}
