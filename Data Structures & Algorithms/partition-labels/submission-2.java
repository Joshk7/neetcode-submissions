class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] furthest = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            furthest[c - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int rightMost = -1;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            rightMost = Math.max(rightMost, furthest[c - 'a']);
            if (right == rightMost) {
                ans.add(right - left + 1);
                left = right + 1;
                rightMost++;
            }
        }

        return ans;
    }
}
