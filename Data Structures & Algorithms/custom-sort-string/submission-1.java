class Solution {
    public String customSortString(String order, String s) {
        int[] orderMap = new int[26];
        Arrays.fill(orderMap, -1);
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            orderMap[c - 'a'] = i + 1;
        }

        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr, (a, b) -> orderMap[a - 'a'] - orderMap[b - 'a']);
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }
}