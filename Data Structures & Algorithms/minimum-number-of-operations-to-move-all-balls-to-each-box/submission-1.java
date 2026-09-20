class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        int[] prefixCount = new int[n + 1];
        int[] indexSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixCount[i + 1] = prefixCount[i] + (boxes.charAt(i) == '1' ? 1 : 0);
            indexSum[i + 1] = indexSum[i] + (boxes.charAt(i) == '1' ? i : 0);
        }

        for (int i = 0; i < n; i++) {
            int left = prefixCount[i];
            int leftSum = indexSum[i];

            int right = prefixCount[n] - prefixCount[i + 1];
            int rightSum = indexSum[n] - indexSum[i + 1];

            res[i] = i * left - leftSum + (rightSum - i * right);
        }

        return res;
    }
}