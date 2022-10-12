import java.util.*;

/*
	https://leetcode.com/problems/largest-perimeter-triangle/
*/
class LargestPerimeterTriangle {
	public static void main(String[] args) {

		int[] nums = {2,1,2};
		System.out.println(new Solution().largestPerimeter(nums)); // 5

 		nums = new int[] {1,2,1};
		System.out.println(new Solution().largestPerimeter(nums)); // 0
	}
}

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i+1] > nums[i+2]) {
                return nums[i] + nums[i+1] + nums[i+2];
            }
        }

        return 0;
    }
}
