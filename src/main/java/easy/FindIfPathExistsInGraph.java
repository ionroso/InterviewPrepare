package easy;

import java.util.*;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
//        int [][] g = new int[][]{{0,1},{1,2},{2,0}};
//        int [][] g = new int[][]{{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
//        int [][] g = new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}};
        int [][] g = new int[][]{{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        System.out.println(validPath3(g.length, g, 7, 5));
    }


    public static boolean validPath3(int n, int[][] edges, int source, int destination) {
        if(n==1)
        {
            if(source==destination) return true;
            return false;
        }

        if(source==destination) return true;

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            List<Integer> nodeAdj = adjList.computeIfAbsent(edge[0], k -> new ArrayList<>());
            nodeAdj.add(edge[1]);

            List<Integer> nodeAdj1 = adjList.computeIfAbsent(edge[1], k -> new ArrayList<>());
            nodeAdj1.add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()){
            int poll = queue.poll();
            visited.add(poll);
            List<Integer> nodeAdj = adjList.get(poll);
            for (Integer neighbor : nodeAdj) {

                if(poll == destination) return true;

                if(!visited.contains(poll) && !queue.contains(neighbor))
                {
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }
    public static boolean validPath2(int n, int[][] edges, int source, int destination) {
        if(n==1)
        {
            if(source==destination) return true;
            return false;
        }

        if(source==destination) return true;

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            List<Integer> nodeAdj = adjList.get(edge[0]);
            if(nodeAdj == null){
                nodeAdj = new ArrayList<>();
                adjList.put(edge[0], nodeAdj);
            }
            nodeAdj.add(edge[1]);

            List<Integer> nodeAdj1 = adjList.get(edge[1]);
            if(nodeAdj1 == null){
                nodeAdj1 = new ArrayList<>();
                adjList.put(edge[1], nodeAdj1);
            }
            nodeAdj1.add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        List<Integer> sourceNeighbour = adjList.getOrDefault(source, new ArrayList<>());
        for (int neighbour : sourceNeighbour) {
            boolean flag =  dfs2(adjList, visited, destination, neighbour);
            if (flag) return true;
        }

        return false;
    }

    private static boolean dfs2(Map<Integer, List<Integer>> adjList, Set<Integer> visited, int d, int v) {
        if(v == d) return true;
        visited.add(v);
        List<Integer> neighbours = adjList.getOrDefault(v, new ArrayList<>());
        for (int neighbour : neighbours) {
            if(visited.contains(neighbour)) continue;

            boolean flag =  dfs2(adjList, visited, d, neighbour);
            if (flag) return true;
        }

        return false;
    }


    public static boolean validPath1(int n, int[][] edges, int source, int destination) {
        if(n==1)
        {
            if(source==destination) return true;
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        for (int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            if(source != edge[0] && source != edge[1]){
                continue;
            }

            int u = source == edge[0] ? edge[0] : edge[1];
            int v = source == edge[0] ? edge[1] : edge[0];

            boolean flag = dfs1(edges.length, edges, visited, destination, u, v);
            if(flag)
                return true;
        }

        return false;
    }

    private static boolean dfs1(int n, int[][] edges, Set<Integer> visited, int d, int parent, int u) {

        if(u == d) return true;

        visited.add(u);

        for (int i = 0; i < n; i++){
            int[] edge = edges[i];
            int u1 = u == edge[0] ? edge[0] : edge[1];
            int v1 = u == edge[0] ? edge[1] : edge[0];

            if(u1!=u || v1 == parent || visited.contains(v1)) continue;

            boolean flag =  dfs1(n, edges, visited, d, u1, v1);
            if(flag)
                return true;
        }

        return false;
    }


}
