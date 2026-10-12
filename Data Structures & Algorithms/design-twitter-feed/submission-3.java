class Twitter {
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;
    private int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(
            userId, k -> new ArrayList<>()
        ).add(
            new int[]{time++, tweetId}
        );
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>(tweetMap.getOrDefault(userId, new ArrayList<>()));
        for (int followeeId : followMap.getOrDefault(userId, new HashSet<>())) {
            feed.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
        }

        feed.sort((a, b) -> b[0] - a[0]);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(10, feed.size()); i++) {
            res.add(feed.get(i)[1]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(
            followerId, 
            k -> new HashSet<>()
        ).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.getOrDefault(
            followerId, 
            new HashSet<>()
        ).remove(followeeId);
    }
}
