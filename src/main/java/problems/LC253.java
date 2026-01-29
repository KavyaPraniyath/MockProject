package problems;

import java.util.Arrays;

public class LC253 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        int count  = 0;
        int endIndex = 0;
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i< n; i++) {
            if (start[i] < end[endIndex]) {
                count++;
            } else {
                endIndex++;
            }
        }
        return count;
    }

    /**
     * intuition
     * Input: intervals = [[0,30],[5,10],[15,20]]
     * Output: 2
     *
     * 0-----------------------------------30
     *   (1)  5-----10                  (1)
     *          (2)    (1) 15------20
     *                         (2)
     */
    public static void main(String[] args) {
        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        LC253 lc253 = new LC253();
        System.out.println(lc253.minMeetingRooms(intervals));
    }
}
