package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        LC56MergeIntervals lc56 = new LC56MergeIntervals();
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result = lc56.merge(intervals);
        System.out.println(Arrays.deepToString( result));
    }
}
