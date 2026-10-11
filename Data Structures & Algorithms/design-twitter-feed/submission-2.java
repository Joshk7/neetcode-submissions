class Twitter {
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;
    private int count;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets = tweetMap.computeIfAbsent(userId, k -> new ArrayList<>());
        tweets.add(new int[]{count, tweetId});
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = followMap.getOrDefault(userId, new HashSet<>());
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        List<int[]> userTweets = tweetMap.getOrDefault(userId, new ArrayList<>());
        if (!userTweets.isEmpty()) {
            int size = userTweets.size();
            if (size > 0) {
                int[] pair = userTweets.get(size - 1);
                int count = pair[0];
                int tweetId = pair[1];
                maxHeap.offer(new int[]{count, userId, tweetId, size - 1});
            }
        }

        for (int followerId : following) {
            List<int[]> followerTweets = tweetMap.get(followerId);
            if (!followerTweets.isEmpty()) {
                int size = followerTweets.size();
                if (size > 0) {
                    int[] pair = followerTweets.get(size - 1);
                    int count = pair[0];
                    int tweetId = pair[1];
                    maxHeap.offer(new int[]{count, followerId, tweetId, size - 1});
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (!maxHeap.isEmpty() && answer.size() < 10) {
            int[] top = maxHeap.poll();
            int count = top[0];
            int accountId = top[1];
            int tweetId = top[2];
            int index = top[3];
            answer.add(tweetId);
            if (index > 0) {
                List<int[]> tweets = tweetMap.get(accountId);
                int[] pair = tweets.get(index - 1);
                int nextCount = pair[0];
                int nextTweetId = pair[1];
                if (!tweets.isEmpty()) {
                    maxHeap.offer(new int[]{nextCount, accountId, nextTweetId, index - 1});
                }
            }
        }

        return answer;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> following = followMap.computeIfAbsent(followerId, k -> new HashSet<>());
        following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> following = followMap.getOrDefault(followerId, new HashSet<>());
        if (following.contains(followeeId)) {
            following.remove(followeeId);
        }
    }
}
