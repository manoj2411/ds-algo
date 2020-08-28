package misc;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.Optional;


// https://leetcode.com/problems/find-right-interval/
//
public class FindRightInterval {

    int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];

        TreeMap<Integer, Integer> starts = new TreeMap<>();

        for (int i = 0; i < intervals.length ; i ++) {
            starts.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length ; i ++) {

            Optional<Integer> j = Optional.ofNullable(starts.ceilingKey(intervals[i][1]));
            if (j.isPresent()) {
                result[i] = starts.get(j.get());
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{3,4}, {2,3}, {1,2}};
        FindRightInterval obj = new FindRightInterval();
        int[] result = obj.findRightInterval(intervals);

        System.out.println(Arrays.toString(result));

    }
}
