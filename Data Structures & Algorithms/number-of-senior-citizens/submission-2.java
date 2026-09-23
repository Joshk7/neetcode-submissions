class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String d : details) {
            int ten = d.charAt(11) - '0';
            int one = d.charAt(12) - '0';
            int age = ten * 10 + one;
            if (age > 60) {
                ans++;
            }
        }
        return ans;
    }
}