/*
	https://leetcode.com/problems/find-peak-element/
*/
class FindPeakElement {
	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		System.out.println(new Solution().findPeakElement(nums)); // 2

		nums = new int[] {1,2,1,3,5,6,4};
		System.out.println(new Solution().findPeakElement(nums)); // 5
	}
}

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
