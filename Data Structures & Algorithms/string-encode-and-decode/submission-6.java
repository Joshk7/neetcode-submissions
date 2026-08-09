class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return null;
        }

        String res = "";
        for (int i = 0; i < strs.size(); i++) {
            if (i == strs.size() - 1) {
                res += strs.get(i); 
                continue;
            }
            res += strs.get(i) + ":;";
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<String>();
        if (str == "") {
            ans.add("");
            return ans;
        }

        if (str == null) {
            return ans;
        }
        for (String s : str.split(":;")) {
            ans.add(s);
        }

        return ans;
    }
}
