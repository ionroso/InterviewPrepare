package easy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 1)
        {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i <= intervals.length-1; i++) {
            if(intervals[i-1][0] == intervals[i][0] || (intervals[i-1][1] >= intervals[i][0])){
                return false;
            }
        }

        return true;
    }
}
