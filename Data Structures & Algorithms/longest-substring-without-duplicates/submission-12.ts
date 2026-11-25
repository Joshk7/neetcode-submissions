class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLongestSubstring(s: string): number {
        const letters = new Set<string>();

        let longest = 0,
            n = s.length,
            l = 0;

        for (let r = 0; r < n; r++) {
            while (letters.has(s[r])) {
                letters.delete(s[l]);
                l++;
            }
            letters.add(s[r]);
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
