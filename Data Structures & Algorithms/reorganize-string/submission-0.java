class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(
            (a, b) -> {
                return b[0] - a[0];
            }
        );

        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        for (int letter = 'a'; letter <= 'z'; letter++) {
            if (letters[letter - 'a'] == 0) continue;
            maxHeap.offer(new int[]{letters[letter - 'a'], letter - 'a'});
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            int firstCount = first[0];
            char firstLetter = (char) (first[1] + 'a');
            if (maxHeap.isEmpty()) {
                if (firstCount > 1) return "";
                sb.append(firstLetter);
                break;
            }
            int[] second = maxHeap.poll();
            int secondCount = second[0];
            char secondLetter = (char) (second[1] + 'a');
            sb.append(firstLetter);
            sb.append(secondLetter);
            
            if (firstCount > 1) {
                maxHeap.offer(new int[]{firstCount - 1, firstLetter - 'a'});
            }

            if (secondCount > 1) {
                maxHeap.offer(new int[]{secondCount - 1, secondLetter - 'a'});
            }
        }

        return sb.toString();
    }
}