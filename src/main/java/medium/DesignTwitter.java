package medium;

import java.util.*;
import java.util.function.BinaryOperator;

public class DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.follow(2, 1);    // User 1 follows user 2.
        List<Integer>rez = twitter.getNewsFeed(2);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        List<Integer> rez1 = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        List<Integer> rez2 = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
        System.out.println();
    }

    static
    class Twitter {
        class Post {
            int id;
            int tweetId;

            public Post(int id, int tweetId) {

                this.id = serial;
                this.tweetId = tweetId;
            }
        }
        int serial = 0;

        Map<Integer, List<Integer>> following;
        Map<Integer, List<Post>> posts;

        public Twitter() {
            following = new HashMap<>();
            posts = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            posts.computeIfAbsent(userId, m->new ArrayList<>()).add(new Post(serial, tweetId));
            following.computeIfAbsent(userId, m->new ArrayList<>());

            serial++;
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> output = new ArrayList<>();

            PriorityQueue<Post> pq = new PriorityQueue<>((o1, o2) -> o2.id-o1.id);

            List<Integer> myFollowers = following.get(userId);
            if(myFollowers != null) {
                for (Integer myFollower : myFollowers) {
                    List<Post> p = posts.get(myFollower);
                    if(p!=null){
                        for (int i = 0; i<p.size(); i++) {
                            pq.offer(p.get(i));
                        }
                    }
                }
            }

            List<Post> myPosts = posts.get(userId);
            if(myPosts!=null){
                for (int i = 0; i<myPosts.size(); i++) {
                    pq.offer(myPosts.get(i));
                }
            }

            int i=0;
            while (!pq.isEmpty() && i<10){
                output.add(pq.poll().tweetId);
                i++;
            }

            return output;
        }

        public void follow(int followerId, int followeeId) {
            followIfDontContains(followerId, followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            unfollowIfContains(followerId, followeeId);
        }

        private void unfollowIfContains(int followerId, int followeeId) {
            if(!following.containsKey(followerId)){
                return;
            }

            following.get(followerId).remove(Integer.valueOf(followeeId));
        }

        private void followIfDontContains(int followerId, int followeeId) {
            if(!following.containsKey(followerId)){
                following.put(followerId, new ArrayList<>());
            }

            if(following.get(followerId).contains(followeeId)){
                return;
            }

            following.get(followerId).add(followeeId);
        }
    }
}
