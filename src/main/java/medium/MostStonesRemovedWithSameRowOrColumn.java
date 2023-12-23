package medium;

public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        return removeStonesRec(stones, 0);
    }

    int removeStonesRec(int[][] stones, int stone){
        return -1;
    }
}
