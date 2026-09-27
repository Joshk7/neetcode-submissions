class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> {
            int freqA = count.get(a), freqB = count.get(b);
            if (freqA != freqB) return Integer.compare(freqA, freqB);
            return Integer.compare(b, a);
        });

        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }
}