class Solution:
    def isValid(self, s: str) -> bool:
        openToClose = {
            ')': '(',
            '}': '{',
            ']': '['
        }

        stack = []
        for c in s:
            if not c in openToClose:
                stack.append(c)
            elif not stack or stack[-1] != openToClose[c]:
                return False
            else:
                stack.pop()

        return len(stack) == 0
