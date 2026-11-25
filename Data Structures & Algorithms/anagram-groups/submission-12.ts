class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs: string[]): string[][] {
        const res: { [key: string]: string[] } = {};
        for (let s of strs) {
            const count: number[] = new Array(26).fill(0);
            for (let c of s) {
                const index = c.charCodeAt(0) - 'a'.charCodeAt(0);
                count[index] += 1;
            }
            const key = count.join(',');
            if (!res[key]) {
                res[key] = [];
            }
            res[key].push(s);
        }

        return Object.values(res);
    }
}
