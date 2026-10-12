class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] letters = new int[26];
        for (char task : tasks) {
            letters[task - 'A']++;
        }

        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        for (int letter = 0; letter < 26; letter++) {
            int count = letters[letter];
            if (count > 0) {
                maxHeap.offer(new int[]{count, letter});
            }
        }

        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int[] top = maxHeap.poll();
                int count = top[0];
                int letter = top[1];
                if (count - 1 > 0) {
                    queue.offer(new int[]{time + n, count - 1, letter});
                }
            }

            if (!queue.isEmpty() && time >= queue.peek()[0]) {
                int[] top = queue.poll();
                int count = top[1];
                int letter = top[2];
                if (count > 0) {
                    maxHeap.offer(new int[]{count, letter});
                }
            } 

        }
        
        return time;
    }
}
