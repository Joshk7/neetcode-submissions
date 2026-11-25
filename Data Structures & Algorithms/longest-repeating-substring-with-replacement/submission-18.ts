class Solution {
    /**
     * @param {string} s
     * @param {number} k
     * @return {number}
     */
    characterReplacement(s: string, k: number): number {
        const letters = new Map<string, number>();
        let longest = 0,
            l = 0,
            r = 0,
            n = s.length,
            maxF = 0;

        while (r < n) {
            letters.set(s[r], (letters.get(s[r]) || 0) + 1);
            maxF = Math.max(maxF, letters.get(s[r])!);
            while (r - l + 1 - maxF > k) {
                letters.set(s[l], letters.get(s[l])! - 1);
                l++;
            }
            longest = Math.max(longest, r - l + 1);
            r++;
        }

        return longest;
    }
}
