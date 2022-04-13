import java.util.*;

/*
        https://leetcode.com/problems/merge-intervals/
*/
class MergeIntervals {
    public static void main(String[] args) {
        int[][][] inputs = {
            {{1,3},{2,6},{8,10},{15,18}},
            {{1,4},{4,5}}
        };

        for(int[][] intervals : inputs) {
            Solution sol = new Solution();

            System.out.print("Intervals: ");
            printIntervals(intervals);

            int[][] result = sol.merge(intervals);

            System.out.print("Result: ");
            printIntervals(result);
            System.out.println();
        }
    }

    static void printIntervals(int[][] intervals) {
        for(int[] pair : intervals)
            System.out.print(Arrays.toString(pair) + " ");
        System.out.println();

    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[]b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> result = new LinkedList<>();

        // select start as min, then keep on going until we start <= end then place

        int i = 0;

        while(i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while(i + 1 < intervals.length && intervals[i+1][0] <= end) {
                i++;
                end = Math.max(end, intervals[i][1]);
            }
            result.add(new int[] {start, end});

            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}

class AlternateSolution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int lastIndex = result.size() - 1;
            int[] last = result.get(lastIndex);
            int[] curr = intervals[i];

            if (curr[0] <= last[1]) { // merge
                result.get(lastIndex)[1] = Math.max(last[1], curr[1]);
            } else { // add new entry
                result.add(curr);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
