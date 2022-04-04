/*
	https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
*/
class FindMinimumInRotatedSortedArrayII {
	public static void main(String[] args) {
		int[] nums = {1,3,5};
		System.out.println(new Solution().findMin(nums)); // 1

		nums = new int[] {2,2,2,0,1,2};
		System.out.println(new Solution().findMin(nums)); // 0

		nums = new int[] {2,2,2,0,1,2,2,2,2,2,2,2,2,2,2};
		System.out.println(new Solution().findMin(nums)); // 0
	}
}

class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while(right - left > 1) {
            int mid = (left + right) / 2;

            if (nums[mid] < nums[right])
                right = mid;
            else if (nums[mid] > nums[right])
                left = mid;
            else
                right--;
        }

        return Math.min(nums[left], nums[right]);
    }
}
