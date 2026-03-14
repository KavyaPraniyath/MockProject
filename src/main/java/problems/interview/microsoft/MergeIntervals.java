package problems.interview.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int n=intervals.length;
        int m=intervals[0].length;
        int start=intervals[0][0];
        int end=intervals[0][1];
        List<int[]> list=new ArrayList();
        for(int i=1;i<n;i++){
            if(end >= intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }else{
                list.add(new int[]{start, end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }
}
