/*
	https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/
class FindFirstLastPositionOfElementInSortedArr {
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 2, 2, 2, 4};
		System.out.println(new Solution().searchRange(nums, 2)); // [1, 5]

		nums = new int[] { 5,7,7,8,8,10 };
		System.out.println(new Solution().searchRange(nums, 8)); // [3, 4]

		nums = new int[] { 5,7,7,8,8,10 };
		System.out.println(new Solution().searchRange(nums, 6)); // [-1, -1]
	}
}

class Solution {
	/*
		complexity of solution:

			time: 	O(log(n))
			space:	O(1)
	*/
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};

        int start = findStart(nums, target);

        if (start == -1) return new int[] {-1, -1};

        int end = findEnd(nums, target, start);

        return new int[] {start, end};
    }

    private int findEnd(int[] nums, int target, int start) {
        int left = start;
        int right = nums.length - 1;

        /*
                 0  1  2. 3. 4. 5. 6
                [1, 2, 2, 2, 2, 2, 4]
                                ^  ^
                 0 1 2 3 4 5
                [5,7,7,8,8,10]
                         ^  ^
        */

        while (right - left > 1) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) left = mid;
            else right = mid;
        }

        if (nums[right] == target) return right;
        else if (nums[left] == target) return left;
        else return -1;
    }

    private int findStart(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        /*
                 0  1  2. 3. 4. 5. 6
                [1, 2, 2, 2, 2, 2, 4]
                 ^                 ^
        */

        while (right - left > 1) {
            int mid = (left + right) / 2;

            if (nums[mid] >= target) right = mid;
            else left = mid;
        }

        if (nums[left] == target) return left;
        else if (nums[right] == target) return right;
        else return -1;
    }
}
