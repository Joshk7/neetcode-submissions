class Solution {
    public int numOfSubarrays(int[] arr) {
        int curSum = 0, oddCnt = 0, evenCnt = 0, res = 0;
        int MOD = (int)1e9 + 7;

        for (int n : arr) {
            curSum += n;
            if (curSum % 2 != 0) {
                res = (res + 1 + evenCnt) % MOD;
                oddCnt++;
            } else {
                res = (res + oddCnt) % MOD;
                evenCnt++;
            }
        }

        return res;
    }
}