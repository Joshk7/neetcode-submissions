class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n * (n + 1) / 2];
        int pos = 0;

        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = i; j < n; j++) {
                total += nums[j];
                sums[pos++] = total;
            }
        }

        Arrays.sort(sums);

        int answer = 0;
        int mod = 1000000007;

        for (int i = left - 1; i < right; i++) {
            answer = (answer + sums[i]) % mod;
        }

        return answer;
    }
}
