package medium;

import java.util.*;

public class LeaderboardTest {
    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard ();
        leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(1));           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
    }

    static
    class Leaderboard {
        class Player {
            Integer id;
            Integer score;

            public Player(Integer id, Integer score) {
                this.id = id;
                this.score = score;
            }

            public Integer getScore() {
                return score;
            }

            public void updateScore(int score){
                this.score += score;
            }

            public void resetScore(){
                this.score = 0;
            }
        }
        Map<Integer, Player> scores;
        PriorityQueue<Player> pqScores ;

        public Leaderboard() {
            scores = new HashMap<>();
            pqScores = new PriorityQueue<>((o1, o2) -> o2.score-o1.score);
        }

        public void addScore(int playerId, int score) {
           Player player = scores.getOrDefault(playerId, new Player(playerId,0));
           player.updateScore(score);
           scores.put(playerId,player);
;
           pqScores.remove(player);
           pqScores.offer(player);
        }

        public int top(int k) {
            List<Player> topPlayers = new ArrayList<>(k);

            int sum = 0;
            int i = 0;
            while (!pqScores.isEmpty() && i<k){
                Player p = pqScores.poll();
                topPlayers.add(p);
                sum+=p.score;
                i++;
            }

            for (Player topPlayer : topPlayers) {
                pqScores.offer(topPlayer);
            }

            return sum;
        }

        public void reset(int playerId) {
            Player player = scores.getOrDefault(playerId, new Player(playerId,0));
            player.resetScore();
            scores.put(playerId, player);
            ;
            pqScores.remove(player);
            pqScores.offer(player);
        }
    }

}
