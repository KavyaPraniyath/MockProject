package problems;

import java.util.Arrays;

public class LC252CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->a[0] - b[0]);
        for (int i = 0 ; i < intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        LC252CanAttendMeetings lc252 = new LC252CanAttendMeetings();
        System.out.println(lc252.canAttendMeetings(intervals));
    }
}
