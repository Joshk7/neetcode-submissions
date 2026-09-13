class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            String item = String.valueOf(num);
            list.add(item);
        }

        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));
        String ans = String.join("", list);
        if (ans.charAt(0) == '0') {
            return "0";
        } else {
            return ans;
        }
    }
}