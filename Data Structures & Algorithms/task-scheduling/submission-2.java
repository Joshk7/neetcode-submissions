class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] letters = new int[26];
        for (char task : tasks) {
            letters[task - 'A']++;
        }

        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b - a
        );

        for (int letterCount : letters) {
            if (letterCount > 0) maxHeap.offer(letterCount);
        }

        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                if (count - 1 > 0) {
                    queue.offer(new int[]{time + n, count - 1});
                }
            }

            if (!queue.isEmpty() && time >= queue.peek()[0]) {
                int[] top = queue.poll();
                int count = top[1];
                if (count > 0) {
                    maxHeap.offer(count);
                }
            } 
        }
        
        return time;
    }
}
