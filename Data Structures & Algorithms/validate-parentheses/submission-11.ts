class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isValid(s: string): boolean {
        const stack: string[] = [];
        const map: { [key: string]: string } = {
            ']': '[',
            ')': '(',
            '}': '{'
        };

        for (let c of s) {
            if (c in map) {
                if (stack.length === 0 || stack[stack.length - 1] != map[c]) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.length === 0;
    }
}
