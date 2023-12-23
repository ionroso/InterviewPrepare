package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaximumPopulationYear {
    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int[][]{{2049,2050}}));
    }

    public static int maximumPopulation(int[][] logs) {

        int[] years = new int[101];

        for (int i = 0; i < logs.length; i++) {
            int birth = logs[i][0];
            int died = logs[i][1]-1;
            for (int j = birth; j <= died; j++) {
                years[j - 1950]++;
            }
        }

        int idx = 0;
        int maxPopYearCount = years[0];
        for (int i = 1; i <= years.length-1; i++) {
            if(maxPopYearCount < years[i]){
                maxPopYearCount = years[i];
                idx = i;
            }
        }
        return idx+1950;
    }
}
