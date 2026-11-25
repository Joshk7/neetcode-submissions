class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLongestSubstring(s: string): number {
        const letters = new Set<string>();
        let longest = 0,
            l = 0,
            r = 0,
            n = s.length;
        
        while (r < n) {
            while (letters.has(s[r])) {
                letters.delete(s[l]);
                l++;
            }
            letters.add(s[r]);
            longest = Math.max(longest, r - l + 1);
            r++;
        }

        return longest;
    }
}
