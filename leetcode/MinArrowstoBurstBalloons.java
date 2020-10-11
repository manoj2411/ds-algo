import java.util.*;

/*
        https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
*/
public class MinArrowstoBurstBalloons {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(sol.findMinArrowShots(points));

        int[][] newPoints = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(sol.findMinArrowShots(newPoints));
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        sort(points);
        int result = 0;
        int i = 0;
        while(i < points.length) {
            int limitEnd = points[i][1];
            while(i + 1 < points.length && points[i+1][0] <= limitEnd) {
                limitEnd = Math.min(limitEnd, points[i+1][1]);
                i++;
            }
            result++;
            i++;
        }
        return result;
    }

    void sort(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0])
                    return Integer.compare(a[1], b[1]);
                else
                    return Integer.compare(a[0], b[0]);
            }
        });
    }
}
