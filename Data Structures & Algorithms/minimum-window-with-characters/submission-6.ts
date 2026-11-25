class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {string}
     */
    minWindow(s: string, t: string): string {
        const tMap = new Map<string, number>();
        const sMap = new Map<string, number>();
        let res = s + '#',
            match = 0,
            target = 0,
            l = 0,
            n = s.length;

        for (let c of t) {
            tMap.set(c, (tMap.get(c) || 0) + 1);
            if (tMap.get(c) === 1) {
                target++;
            }
        }

        console.log(target);
        
        for (let r = 0; r < n; r++) {
            sMap.set(s[r], (sMap.get(s[r]) || 0) + 1);
            if (sMap.get(s[r]) === tMap.get(s[r])) {
                match++;
            }

            while (match == target) {
                if (res.length > r - l + 1) {
                    res = s.slice(l, r + 1);
                }

                sMap.set(s[l], sMap.get(s[l])! - 1);
                if (sMap.get(s[l]) === tMap.get(s[l]) - 1) {
                    match--;
                }
                l++;
            }
        }

        if (res.length > s.length) {
            return "";
        }

        return res;
    }
}
