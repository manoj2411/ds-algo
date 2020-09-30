import java.util.*;

/*
        https://leetcode.com/problems/insert-interval/
*/
public class InsertInterval {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] result = sol.insert(intervals, newInterval);

        System.out.print("Result: [");
        for(int[] pair : result) {
            System.out.print(Arrays.toString(pair));
        }
        System.out.println("]");
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int i = 0;

        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        int minStart = newInterval[0];
        int maxEnd = newInterval[1];
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            minStart = Math.min(minStart, intervals[i][0]);
            maxEnd = Math.max(maxEnd, intervals[i][1]);
            i++;
        }
        int[] interval = {minStart, maxEnd};
        res.add(interval);

        while(i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        int[][] result = new int[res.size()][2];
        for(i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
