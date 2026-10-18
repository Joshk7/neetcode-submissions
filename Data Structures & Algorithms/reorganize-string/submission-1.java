class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int n = s.length();
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();

        int maxFreq = Arrays.stream(freq).max().getAsInt();
        if (maxFreq > (n + 1) / 2) return "";

        while (sb.length() < s.length()) {
            int maxIdx = findMaxIndex(freq);
            char maxChar = (char) (maxIdx + 'a');
            sb.append(maxChar);
            freq[maxIdx]--;

            if (freq[maxIdx] == 0) {
                continue;
            }

            int tmp = freq[maxIdx];
            freq[maxIdx] = Integer.MIN_VALUE;
            int nextMaxIdx = findMaxIndex(freq);
            char nextMaxChar = (char) (nextMaxIdx + 'a');
            sb.append(nextMaxChar);
            freq[maxIdx] = tmp;
            freq[nextMaxIdx]--;
        }

        return sb.toString();
    }

    private int findMaxIndex(int[] freq) {
        int maxIdx = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > freq[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}