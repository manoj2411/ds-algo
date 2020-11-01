import java.util.*;

/*
    https://leetcode.com/problems/furthest-building-you-can-reach/
*/
class FurthestBuildingCanReach {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] heights = {4,12,2,7,3,18,20,3,19};
        int bricks = 10;
        int ladders = 2;
        int result = sol.furthestBuilding(heights, bricks, ladders);
        // ans :7
        System.out.println(result);
    }
}

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> chunk_used = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < heights.length - 1; i++) {
            if(heights[i + 1] <= heights[i])
                continue;

            int diff = heights[i + 1] - heights[i];

            if(diff > bricks && ladders == 0)
                return i;

            if(bricks >= diff) {
                chunk_used.add(bricks - diff);
                bricks -= diff;
            } else if(!chunk_used.isEmpty() && (chunk_used.peek() + bricks) >= diff) {
                ladders -= 1;
                bricks += chunk_used.poll();
                i--;
                continue;
            } else {
                ladders -= 1;
            }
        }

        return heights.length - 1;

    }
}
