class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    encode(strs: string[]): string {
        const res: string[] = [];
        for (const str of strs) {
            res.push(String(str.length));
            res.push('#');
            res.push(str);
        }
        return res.join("");
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    decode(str: string): string[] {
        const res: string[] = [];
        const n = str.length;
        let i = 0
        while (i < n) {
            let j = i;
            while (j < n && str[j] != '#') {
                j++;
            }
            let length = parseInt(str.slice(i, j));
            j++;
            res.push(str.slice(j, j + length));
            i = j + length;
        }
        return res;
    }
}
