class Twitter {

    Map<Integer, List<Integer>> userIdToFollowerId;
    Map<Integer, List<Pair<Integer, Integer>>> userIdToTweet;
    int tweetNumber;

    public Twitter() {
        userIdToFollowerId = new HashMap<>();
        userIdToTweet = new HashMap<>();
        tweetNumber = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetNumber += 1;

        Pair<Integer, Integer> tweet =
            new Pair<>(tweetId, tweetNumber);

        userIdToTweet.putIfAbsent(userId, new ArrayList<>());
        userIdToTweet.get(userId).add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        // Max-heap: Most recent tweet at the top
        PriorityQueue<Pair<Integer, Integer>> maxHeap =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(b.tweetNumber, a.tweetNumber)
            );

        // Add user's own tweets
        for (Pair<Integer, Integer> tweet :
                userIdToTweet.getOrDefault(userId, Collections.emptyList())) {
            maxHeap.add(tweet);
        }

        // Add tweets from all users being followed
        for (int followeeId :
                userIdToFollowerId.getOrDefault(userId, Collections.emptyList())) {

            for (Pair<Integer, Integer> tweet :
                    userIdToTweet.getOrDefault(followeeId, Collections.emptyList())) {
                maxHeap.add(tweet);
            }
        }

        // Extract 10 most recent tweets
        List<Integer> newsFeed = new ArrayList<>();

        while (!maxHeap.isEmpty() && newsFeed.size() < 10) {
            newsFeed.add(maxHeap.poll().tweetId);
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {

        // Cannot follow yourself
        if (followerId == followeeId)
            return;

        userIdToFollowerId.putIfAbsent(followerId, new ArrayList<>());

        List<Integer> followees = userIdToFollowerId.get(followerId);

        // Avoid duplicate followees
        if (!followees.contains(followeeId))
            followees.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (userIdToFollowerId.containsKey(followerId)) {
            userIdToFollowerId.get(followerId)
                .remove(Integer.valueOf(followeeId));
        }
    }

    class Pair<K, V> {
        K tweetId;
        V tweetNumber;

        Pair(K tweetId, V tweetNumber) {
            this.tweetId = tweetId;
            this.tweetNumber = tweetNumber;
        }
    }
}