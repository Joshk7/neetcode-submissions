class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s: string, t: string): boolean {
        const letters: number[] = new Array<number>(26).fill(0);
        for (const c of s) {
            const key: number = c.charCodeAt(0) - 'a'.charCodeAt(0);
            letters[key]++;
        }

        for (const c of t) {
            const key: number = c.charCodeAt(0) - 'a'.charCodeAt(0);
            letters[key]--;
        }

        for (const letter of letters) {
            if (letter != 0) {
                return false;
            }
        }

        return true;
    }
}
