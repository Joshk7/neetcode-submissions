class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for (String cur : paths) {
            if (cur.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!cur.equals("") && !cur.equals(".")) {
                stack.push(cur);
            }
        }

        return "/" + String.join("/", stack);

        // Stack<String> stack = new Stack<>();
        // StringBuilder cur = new StringBuilder();

        // for (char c : (path + "/").toCharArray()) {
        //     if (c == '/') {
        //         if (cur.toString().equals("..")) {
        //             if (!stack.isEmpty()) stack.pop();
        //         } else if (
        //             !cur.toString().equals("") && 
        //             !cur.toString().equals(".")
        //         ) {
        //             stack.push(cur.toString());
        //         }
        //         cur.setLength(0);
        //     } else {
        //         cur.append(c);
        //     }
        // }

        // return "/" + String.join("/", stack);
    }
}