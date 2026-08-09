class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        String sortedS1 = new String(c1);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                char[] subStrArr = s2.substring(i, j + 1).toCharArray();
                Arrays.sort(subStrArr);
                String sortedSubStr = new String(subStrArr);

                if (sortedSubStr.equals(sortedS1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
