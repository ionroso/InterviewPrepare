package medium;

import java.util.*;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    public static void main(String[] args) {
        int logs[][] = new int[][] {{9,0,3},{0,2,7},{12,3,1},{5,5,2},{3,4,5},{1,5,0},{6,2,4},{2,5,3},{7,7,3}};
        System.out.println(earliestAcq(logs, 8));
    }

    static public int earliestAcq1(int[][] logs, int n) {

        HashMap<Integer, HashSet<Integer>> friendMap = new HashMap<>();

        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < logs.length; i++) {
            HashSet<Integer> friend1Set = friendMap.getOrDefault(logs[i][1], new HashSet<>());
            friend1Set.add(logs[i][2]);
            friendMap.put(logs[i][1], friend1Set);

            HashSet<Integer> friend2Set = friendMap.getOrDefault(logs[i][2], new HashSet<>());
            friend2Set.add(logs[i][1]);
            friendMap.put(logs[i][2], friend2Set);

            HashSet<Integer> visited = new HashSet<>();
            dfs(friendMap, 0, visited);

            if(visited.size() == n) {
                return logs[i][0];
            }
        }

        return -1;
    }

    static private void dfs(HashMap<Integer, HashSet<Integer>> friendMap, int start, HashSet<Integer> visited) {
        if(visited.contains(start)) {
            return;
        }

        visited.add(start);
        HashSet<Integer> friendSet = friendMap.get(start);

        if(friendSet != null) {
            for(Integer element : friendSet) {
                dfs(friendMap, element, visited);
            }
        }
    }

    static public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));

        UnionFindSimplified union = new UnionFindSimplified(n);
        int lastConnected = -1;
        for (int[] log : logs) {
            if(union.find(log[1])!=union.find(log[2])){
                union.unify(log[1], log[2]);
                lastConnected = log[0];
            }
        }

        return union.numComponents == 1 ? lastConnected : -1;
    }

    static class UnionFindSimplified {
        private int[] id;

        private int numComponents;

        public UnionFindSimplified(int size) {
            if (size <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");

            numComponents = size;
            id = new int[size];

            for (int i = 0; i < size; i++) {
                id[i] = i;
            }
        }

        public int find(int p) {
            int root = p;
            while (root != id[root])
            {
                root = id[root];
            }

            return root;
        }

        public void unify(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (root1 == root2) {
                return;
            }

            id[root1] = root2;
            numComponents--;
        }
    }
}
