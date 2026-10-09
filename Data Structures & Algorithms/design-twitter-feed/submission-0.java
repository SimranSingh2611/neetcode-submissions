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

        Pair<Integer, Integer> tweet = new Pair<>(tweetId, tweetNumber);

        userIdToTweet.putIfAbsent(userId, new ArrayList<>());
        userIdToTweet.get(userId).add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        // Max-heap: most recent tweet at the top
        PriorityQueue<Pair<Integer, Integer>> maxHeap =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(b.second, a.second)
            );

        // Add user's own tweets
        for (Pair<Integer, Integer> tweet :
                userIdToTweet.getOrDefault(
                    userId, Collections.emptyList())) {
            maxHeap.add(tweet);
        }

        // Add tweets from all followees
        for (int followeeId :
                userIdToFollowerId.getOrDefault(
                    userId, Collections.emptyList())) {

            for (Pair<Integer, Integer> tweet :
                    userIdToTweet.getOrDefault(
                        followeeId, Collections.emptyList())) {
                maxHeap.add(tweet);
            }
        }

        // Extract the 10 most recent tweets
        List<Integer> newsFeed = new ArrayList<>();

        while (!maxHeap.isEmpty() && newsFeed.size() < 10) {
            newsFeed.add(maxHeap.poll().first);
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId)
            return;

        userIdToFollowerId.putIfAbsent(
            followerId, new ArrayList<>()
        );

        List<Integer> followees =
            userIdToFollowerId.get(followerId);

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
        K first;
        V second;

        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}