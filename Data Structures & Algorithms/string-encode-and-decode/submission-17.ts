class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    encode(strs: string[]): string {
        if (strs.length === 0) return '';
        let sizes: number[] = [],
            parts: string[] = [];
        for (let s of strs) {
            sizes.push(s.length);
        }
        for (let sz of sizes) {
            parts.push(String(sz), ',');
        }
        parts.push('#', ...strs);
        return parts.join('');
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    decode(str: string): string[] {
        if (str.length === 0) return [];
        let sizes: number[] = [],
            res: string[] = [],
            i = 0;
        while (str[i] !== '#') {
            let j = i;
            while (str[j] !== ',') {
                j++;
            }
            sizes.push(parseInt(str.substring(i, j), 10));
            i = j + 1;
        }

        i++;
        for (let sz of sizes) {
            res.push(str.substr(i, sz));
            i += sz;
        }
        return res;
    }
}
