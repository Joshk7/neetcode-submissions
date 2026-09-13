class Solution {
    public String largestNumber(int[] nums) {
        List<String> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(String.valueOf(num));
        }

        StringBuilder res = new StringBuilder();
        while (!arr.isEmpty()) {
            int maxi = 0;
            for (int i = 1; i < arr.size(); i++) {
                if ((arr.get(i) + arr.get(maxi)).compareTo(arr.get(maxi) + arr.get(i)) > 0) {
                    maxi = i;
                }
            }
            res.append(arr.get(maxi));
            arr.remove(maxi);
        }

        String result = res.toString();
        return result.charAt(0) == '0' ? "0" : result;
    }
}