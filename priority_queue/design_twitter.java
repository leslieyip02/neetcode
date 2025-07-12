class Twitter {

    private class Tweet implements Comparable<Tweet> {

        static int count = 0;

        int tweetId;
        int time;

        Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = count;
            count++;
        }

        @Override
        public int compareTo(Tweet other) {
            return other.time - time;
        }
    }

    Map<Integer, Queue<Tweet>> tweets;
    Map<Integer, Set<Integer>> followers;

    public Twitter() {
        this.tweets = new HashMap<>();
        this.followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
        }
        tweets.get(userId).add(new Tweet(tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> combined = new PriorityQueue<>();
        if (tweets.containsKey(userId)) {
            combined.addAll(tweets.get(userId));
        }

        if (followers.containsKey(userId)) {
            for (int followeeId : followers.get(userId)) {
                combined.addAll(tweets.get(followeeId));
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!combined.isEmpty() && feed.size() < 10) {
            feed.add(combined.poll().tweetId);
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        followers.get(followerId).remove(followeeId);
    }
}

