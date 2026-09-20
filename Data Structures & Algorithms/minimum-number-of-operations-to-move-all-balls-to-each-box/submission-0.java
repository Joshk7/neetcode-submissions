class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int operations = 0;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                
                if (boxes.charAt(j) == '1') operations += Math.abs(j - i);
            }
            ans[i] = operations;
        }

        return ans;
    }
}