package medium;

import java.util.*;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> output = new ArrayList<>();
        Stack<Integer> currPath;
        boolean[] viz = new boolean[n];
        viz[0] = true;
        for (int adj : graph[0]) {
            viz = new boolean[n];
            viz[0] = true;
            currPath = new Stack<>();
            currPath.add(0);
            dfs(graph, adj, viz, currPath, output);
        }

        return output;
    }

    private void dfs(
            int[][] graph,
            int curr,
            boolean[] viz,
            Stack<Integer> currPath,
            List<List<Integer>> output) {
        if(viz[curr]) return;

        if(curr == viz.length-1){
            List<Integer> path = new ArrayList<>();
            for (int c : currPath) {
                if(viz[c]){
                    path.add(c);
                }
            }
            output.add(path);
        }

        viz[curr] = true;
        currPath.add(curr);

        for (int adj : graph[curr]) {
            dfs(graph, adj, viz, currPath, output);
        }

        viz[curr] = false;
        currPath.pop();
    }
}
