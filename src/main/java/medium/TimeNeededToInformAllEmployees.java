package medium;

import java.util.*;

public class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        int n = 4;
        int headID = 0;
        int[] manager = {-1,0,0,1};
        int[] informTime = {1,2,0,0};
        System.out.println(new TimeNeededToInformAllEmployees().numOfMinutes(n,headID,manager,informTime));
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            g.computeIfAbsent(manager[i],k->new ArrayList<>()).add(i);
        }

        int rez = 0;
        for (Integer child : g.get(headID)) {
            rez=Math.max(rez, dfs(g, child, informTime) + informTime[child]);
            System.out.println();
        }


        return rez+informTime[headID];
    }

    private int dfs(Map<Integer, List<Integer>> g, Integer parent, int[] informTime) {
        List<Integer> children =  g.get(parent);
        if(children == null) return 0;

        int rez = 0;
        for (Integer child : children) {
            int time = dfs(g, child, informTime) + informTime[child];
            rez=Math.max(rez, time);
        }

        return rez;
    }
}
