
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class designTwitter {
    HashMap<Integer, Set<Integer>> followMap;
    HashMap<Integer, List<int[]>> tweetMap;
    int count;

    public designTwitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.count = 0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {count, tweetId});
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
        count--;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        if (followMap.get(userId).size() >= 10) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );

        for (int followeeId : followMap.get(userId)) {
            if (!tweetMap.containsKey(followeeId)) continue;
            List<int[]> tweets = tweetMap.get(followeeId);
            int index = tweets.size() - 1;
            int[] tweet = tweets.get(index);
            maxHeap.offer(new int[]{-tweet[0], tweet[1], followeeId, index - 1});

            if (maxHeap.size() > 10) {
                maxHeap.poll();
            }
        }

        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            minHeap.offer(new int[]{-top[0], top[1], top[2], top[3]});
        }
        } else {
            for (int followeeId : followMap.get(userId)) {
                if (!tweetMap.containsKey(followeeId)) continue;
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index - 1});
            }
        }

        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] top = minHeap.poll();
            res.add(top[1]);
            int nextIndex = top[3];
            if (nextIndex >= 0) {
                List<int[]> tweets = tweetMap.get(top[2]);
                int[] nextTweet = tweets.get(nextIndex);
                minHeap.offer(new int[]{nextTweet[0], nextTweet[1], top[2], nextIndex - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    public static void main (String[] args) {
        designTwitter twitter = new designTwitter();

        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); 

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1)); 

        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); 
    }
}
