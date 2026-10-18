class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (char task = 'A'; task <= 'Z'; task++) {
            if (freq[task - 'A'] == 0) continue;
            maxHeap.offer(freq[task - 'A']);
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            while (!q.isEmpty() && time >= q.peek()[0]) {
                maxHeap.offer(q.poll()[1]);
            }

            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                if (count > 1) {
                    q.offer(new int[]{time + n + 1, count - 1});
                }
            }
        }

        return time;
    }
}
