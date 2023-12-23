package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OnlineElectionTest {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0,0,0,0,1}, new int[] {0,6,39,52,75});
            topVotedCandidate.q(45); // return 0, At time 3, the votes are [0], and 0 is leading.
            topVotedCandidate.q(49); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
            topVotedCandidate.q(59); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
            topVotedCandidate.q(68); // return 0
            topVotedCandidate.q(42); // return 0
            topVotedCandidate.q(99); // return 1
            topVotedCandidate.q(26); // return 1
        }

        class TopVotedCandidate {
            TreeMap<Integer, Integer> timeToId;

            public TopVotedCandidate(int[] persons, int[] times) {
                this.timeToId = new TreeMap<>();
                Map<Integer, Integer> counts = new HashMap<>();

                int winnerCount = -1;
                int idOfWinner = -1;
                for (int i = 0; i < persons.length; i++) {
                    int count = counts.getOrDefault(persons[i], 0);
                    counts.getOrDefault(persons[i], ++count);
                    if(winnerCount <= count) {
                        winnerCount = count;
                        idOfWinner = persons[i];
                    }


                    timeToId.put(times[i], idOfWinner);
                }
            }

            public int q(int t) {
               int rez =  timeToId.get(timeToId.floorKey(t));
                System.out.println(rez);
                return rez;
            }
        }
    }
}
