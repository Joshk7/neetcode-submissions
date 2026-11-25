class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isPalindrome(s: string): boolean {
        let l = 0;
        let r = s.length - 1;
        while (l < r) {
            if (!this.isAlphaNumeric(s[l])) {
                l++;
            } else if (!this.isAlphaNumeric(s[r])) {
                r--;
            } else if (s[l].toUpperCase() === s[r].toUpperCase()) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    private isAlphaNumeric(str: string): boolean {
        return /^[a-z0-9]+$/i.test(str);
    }
}
