import java.util.*;

//      https://leetcode.com/problems/majority-element-ii/

public class MajorityElementII {
    static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int m1 = 0;
            int m2 = 0;
            int count1 = 0;
            int count2 = 0;

            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == m1)
                    count1++;
                else if(nums[i] == m2)
                    count2++;
                else if(count1 == 0) {
                    m1 = nums[i];
                    count1++;
                } else if(count2 == 0) {
                    m2 = nums[i];
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
            List<Integer> result = new LinkedList<>();

            if(count(m1, nums) > (nums.length / 3))
                result.add(m1);
            if(count2 > 0 && count(m2, nums) > (nums.length / 3))
                result.add(m2);
            return result;
        }

        int count(int element, int[] nums) {
            int count = 0;
            for(int i = 0; i < nums.length; i++)
                if(nums[i] == element) count++;

            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] inputs = {
            {1,1,1,3,3,2,2,2},
            {3,2,3},
            {0,0,0},
            {0,-1,2,-1},
            {1,2,2,3,2,1,1,3}
        };
        for(int[] nums : inputs) {
            System.out.println("\nInput : " + Arrays.toString(nums));
            System.out.println("Result : " + sol.majorityElement(nums));
        }
    }
}
