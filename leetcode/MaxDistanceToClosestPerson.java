import java.util.*;

/*
        https://leetcode.com/problems/maximize-distance-to-closest-person/
*/
class MaxDistanceToClosestPerson {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] input = {
            {1,0,0,0,1,0,1},
            {1,0,0,0},
            {0,1,0,0,0},
            {1,0}
        };

        for(int[] seats : input) {
            System.out.println("Seats: " + Arrays.toString(seats));
            System.out.println("Maxi Distance to Closest Person: " + sol.maxDistToClosest(seats));
        }
    }
}

class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev = -1;
        int count = 0;
        int max = 1;
        for(int i = 0; i < seats.length ; i++) {

            if(seats[i] == 0) {
                count++;
            } else {
                if (prev == -1) {
                    max = count;
                } else {
                    max = Math.max(max, (i - prev) / 2);
                }
                count = 0;
                prev = i;
            }
        }

        max = Math.max(max, seats.length - 1 - prev);

        return max;
    }
}
