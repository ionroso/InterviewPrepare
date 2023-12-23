package medium;

/*
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3
 */
public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        boolean rez = dfs(arr, visited, start + arr[start]);
        if(!rez){
           rez = dfs(arr, visited, start - arr[start]);
        }
        return rez;
    }

    private boolean dfs(int[] arr, boolean[] visited, int start) {
        if(start<0 || start>=arr.length) return false;
        if(visited[start]) return false;

        if(arr[start] == 0) return true;

        visited[start] = true;

        boolean rez = dfs(arr, visited, start + arr[start]);
        if(!rez){
            rez = dfs(arr, visited, start - arr[start]);
        }
        return rez;
    }
}
