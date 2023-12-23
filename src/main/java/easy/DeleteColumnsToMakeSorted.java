package easy;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        if(strs.length == 0 || strs.length == 1) return 0;

        int n = strs[0].length();
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < strs.length; j++) {
                if(strs[j-1].charAt(i) - 'a' > strs[j].charAt(i) - 'a'){
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
