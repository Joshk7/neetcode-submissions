class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(String.valueOf(str.length()));
            encoded.append("#");
            encoded.append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        char[] letters = str.toCharArray();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (letters[j] != '#') {
                j++;
            }
            char[] lengthChars = Arrays.copyOfRange(letters, i, j);
            int length = Integer.parseInt(String.valueOf(lengthChars));
            char[] wordChars = Arrays.copyOfRange(letters, j + 1, j + 1 + length);
            decoded.add(String.valueOf(wordChars));
            i = j + 1 + length;
        }
        return decoded;
    }
}
