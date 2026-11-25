class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs: string[]): string[][] {
        const anagrams = new Map<string, Array<string>>();
        for (const str of strs) {
            const letters = new Array<number>(26).fill(0);
            for (const c of str) {
                const index = c.charCodeAt(0) - 'a'.charCodeAt(0);
                letters[index]++;
            }
            const key: string = letters.join(',');
            if (!anagrams.has(key)) {
                anagrams.set(key, []);
            }
            const bucket: Array<string> = anagrams.get(key);
            bucket.push(str);
        }

        const ans = [];
        for (const bucket of anagrams.values()) {
            ans.push(bucket);
        }

        return ans;
    }
}
