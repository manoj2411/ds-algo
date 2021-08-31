/*
	https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*/
class FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {
		int[] arr = {3,4,5,1,2};
		System.out.println(new Solution().findMin(arr)); // 1

		arr = new int[] {4,5,6,7,0,1,2};
		System.out.println(new Solution().findMin(arr)); // 0

		arr = new int[] {11,13,15,17};
		System.out.println(new Solution().findMin(arr)); // 11
	}
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(right - left > 1) {
            int mid = (right + left) / 2;

            if (nums[mid] < nums[right]) right = mid;
            else left = mid;
        }

        return Math.min(nums[right], nums[left]);
    }
}
