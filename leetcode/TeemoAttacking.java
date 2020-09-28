/*
        https://leetcode.com/problems/teemo-attacking/
*/
public class TeemoAttacking {

    static class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if(timeSeries.length == 0) return 0;
            else if(timeSeries.length == 1) return duration;

            int result = duration;

            for(int i = 1; i < timeSeries.length; i++) {
                result += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] timeSeries1 = {1,2,4}; // res: 5
        System.out.println(sol.findPoisonedDuration(timeSeries1, 2));
        int[] timeSeries2 = {1,4}; // res: 4
        System.out.println(sol.findPoisonedDuration(timeSeries2, 2));
        int[] timeSeries3 = {1,2}; // res: 3
        System.out.println(sol.findPoisonedDuration(timeSeries3, 2));
        int[] timeSeries4 = {1,2,3,4,5,6,7,8,9}; // res: 9
        System.out.println(sol.findPoisonedDuration(timeSeries4, 1));

    }
}
