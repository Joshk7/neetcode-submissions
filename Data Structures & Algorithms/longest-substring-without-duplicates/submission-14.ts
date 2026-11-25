class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLongestSubstring(s: string): number {
        const map = {};
        let l = 0,
            res = 0;
        
        for (let r = 0; r < s.length; r++) {
            if (s[r] in map) {
                l = Math.max(map[s[r]] + 1, l);
            }

            map[s[r]] = r
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
