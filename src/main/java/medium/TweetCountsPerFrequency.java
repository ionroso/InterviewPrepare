package medium;

import utility.LeetcodeArgsParser;
import utility.LeetcodeInputIterator;
import utility.LeetcodeMethodsCallStackInputParser;

import java.util.*;

public class TweetCountsPerFrequency {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {

            String methods = "[]";
            String input = "[]";

            LeetcodeInputIterator methodItr = new LeetcodeInputIterator(new LeetcodeMethodsCallStackInputParser(","), methods);
            LeetcodeInputIterator inputItr = new LeetcodeInputIterator(new LeetcodeArgsParser(), input);


            TweetCounts tweetCounts = new TweetCounts();

            Iterator<String> methodIterator = methodItr;
            Iterator<String> inputIterator = inputItr;
            int y = -1;
            while (methodIterator.hasNext()) {
                y++;
                System.out.print(y + " ");

                String methodName = methodIterator.next();
                String val = inputIterator.next();
                System.out.print(y + " ");
                switch (methodName) {
                    case "TweetCounts": {
                        System.out.println(y + " constr");
                        break;
                    }
                    case "recordTweet": {
                        String[] split = val.split(",");

                        tweetCounts.recordTweet(split[0], Integer.valueOf(split[1]));
                        break;
                    }
                    case "getTweetCountsPerFrequency": {
                        String[] split = val.split(",");

                        tweetCounts.getTweetCountsPerFrequency(split[0], split[1], Integer.valueOf(split[2]), Integer.valueOf(split[3]));
                        break;
                    }
                }

                System.out.println();
            }
//
//            TweetCounts tweetCounts = new TweetCounts();
//            tweetCounts.recordTweet("tweet3", 0);                              // New tweet "tweet3" at time 0
//            tweetCounts.recordTweet("tweet3", 60);                             // New tweet "tweet3" at time 60
//            tweetCounts.recordTweet("tweet3", 10);                             // New tweet "tweet3" at time 10
//            tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); // return [2]; chunk [0,59] had 2 tweets
//            tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // return [2,1]; chunk [0,59] had 2 tweets, chunk [60,60] had 1 tweet
//            tweetCounts.recordTweet("tweet3", 120);                            // New tweet "tweet3" at time 120
//            tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // return [4]; chunk [0,210] had 4 tweets
        }

        class TweetCounts {

            static final Map<String, Integer> MY_MAP = Map.of(
                    "minute", 60,
                    "hour", 3600,
                    "day", 86400
            );
            Map<String, NavigableSet<Integer>> tweetToOccurrence;
            public TweetCounts() {
                tweetToOccurrence = new HashMap<>();
            }

            public void recordTweet(String tweetName, int time) {
                tweetToOccurrence.computeIfAbsent(tweetName, k->new TreeSet<>()).add(time);
            }

            public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
                if(!tweetToOccurrence.containsKey(tweetName)){
                    return List.of();
                }

                int step = MY_MAP.get(freq);

                NavigableSet<Integer> subset = tweetToOccurrence.get(tweetName).subSet(startTime, true, endTime, true);
                List<Integer> output = new ArrayList<>();
                int i=startTime;
                for (; i < endTime; i+=step) {
                    output.add((int)tweetToOccurrence.get(tweetName).subSet(i, true, i+step-1, true).stream().count());
                }

                if(i == endTime){
                    output.add((int)tweetToOccurrence.get(tweetName).subSet(i, true, endTime, true).stream().count());
                }

                return output;
            }
        }
    }
}
