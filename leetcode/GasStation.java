import java.util.*;

class GasStation {
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int len = gas.length;

            // checking the case if a solution is possible or not
            // if the diff is negative then eventually we'll not have enogh gas to travel
            int diff = 0;
            for(int i = 0; i < len; i++) diff += gas[i] - cost[i];
            if(diff < 0) return -1; // diff is negative means no answer possible

            // Now we know that we have a valid starting point
            int start = 0;
            diff = 0;
            for(int i = 0; i < len; i++) {
                diff += gas[i] - cost[i];
                if(diff < 0) { // reset start point
                    start = i + 1;
                    diff = 0;
                }
            }
            return start;
        }
    }

    public static void main(String[] args) {
        int[][] inputs = {
            {1,2,3,4,5},{3,4,5,1,2},
            {2,3,4},{3,4,3},
            {1},{2},
            {2},{1},
            {2,3,4,1,2,3,4,5},{2,4,3,3,4,5,1,2},
            {7,1,0,11,4},{5,9,1,2,5}
        };
        Solution sol = new Solution();

        for(int i = 0; i < inputs.length; i += 2) {
            int[] gas = inputs[i];
            int[] cost = inputs[i + 1];
            System.out.println("\nGas: " + Arrays.toString(gas));
            System.out.println("Cost: " + Arrays.toString(cost));
            System.out.println("starting point: " + sol.canCompleteCircuit(gas, cost));
        }
    }
}
