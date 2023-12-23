package medium;

import java.util.*;
import java.util.stream.IntStream;

public class KillProcess {
    public static void main(String[] args) {

        List<Integer> pid = List.of(1,2,3);
        List<Integer> ppid = List.of(0,1,2);
        List<Integer> rez = new KillProcess().killProcess(pid, ppid, 1);
        for (Integer id : rez) {
            System.out.print(id + " ");
        }
    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> output = new ArrayList<>();
        output.add(kill);

        for (int index : getIndexes(ppid, kill)) {
            dfs(pid, ppid, index, output);
        }

        return output;
    }

    private void dfs(List<Integer> pid, List<Integer> ppid, int index, List<Integer> output) {
        int curr = pid.get(index);
        output.add(curr);

        for (int i : getIndexes(ppid, curr)) {
            dfs(pid, ppid, i, output);
        }
    }

    int[] getIndexes(List<Integer> values, int find){
        return IntStream.range(0, values.size())
                .filter(i -> Objects.equals(values.get(i), find))
                .toArray();
    }
}
