class Solution {
    public int[] minOperations(String boxes) {
        // int n = boxes.length();
        // int[] res = new int[n];
        // int[] prefixCount = new int[n + 1];
        // int[] indexSum = new int[n + 1];

        // for (int i = 0; i < n; i++) {
        //     prefixCount[i + 1] = prefixCount[i] + (boxes.charAt(i) == '1' ? 1 : 0);
        //     indexSum[i + 1] = indexSum[i] + (boxes.charAt(i) == '1' ? i : 0);
        // }

        // for (int i = 0; i < n; i++) {
        //     int left = prefixCount[i];
        //     int leftSum = indexSum[i];

        //     int right = prefixCount[n] - prefixCount[i + 1];
        //     int rightSum = indexSum[n] - indexSum[i + 1];

        //     res[i] = i * left - leftSum + (rightSum - i * right);
        // }

        // for (int i = 0; i < n + 1; i++) {
        //     System.out.println(
        //         "index (%s) count (%d) indexSum (%d)"
        //         .formatted(i, prefixCount[i], indexSum[i])
        //     );
        // }

        // return res;

        int n = boxes.length();
        int[] res = new int[n];

        int balls = 0, moves = 0;
        for (int i = 0; i < n; i++) {
            res[i] = balls + moves;
            moves += balls;
            balls += boxes.charAt(i) - '0';
        }

        balls = moves = 0;
        for (int i = n - 1; i >= 0; i--) {
            res[i] += balls + moves;
            moves += balls;
            balls += boxes.charAt(i) - '0';
        }

        return res;
    }
}