class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);
        int i = 0;
        while (i < n) {
            int start = hand[i];
            for (int key = start; key < start + groupSize; key++) {
                if (!map.containsKey(key)) return false;
                map.put(key, map.get(key) - 1);
                int value = map.get(key);
                if (value == 0) {
                    map.remove(key);
                }
            }

            // Move to the next available card
            while (i < n && !map.containsKey(hand[i])) {
                i++;
            }
        }

        return true;
    }
}
