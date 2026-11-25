class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isPalindrome(s: string): boolean {
        let newStr = '';
        for (let c of s) {
            if (this.isAlphanumeric(c)) {
                newStr += c.toLowerCase();
            }
        }

        return newStr === newStr.split('').reverse().join('');
    }

    isAlphanumeric(char: string): boolean {
        return (
            (char >= 'a' && char <= 'z') ||
            (char >= 'A' && char <= 'Z') ||
            (char >= '0' && char <= '9')
        );
    }
}
