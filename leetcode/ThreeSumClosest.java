import java.util.*;

/*
	https://leetcode.com/problems/3sum-closest/
*/
class ThreeSumClosest {
	public static void main(String[] args) {
		int[] arr =  {-1,2,1,-4};
		System.out.println(new Solution().threeSumClosest(arr, 1)); // 2

		arr = new int[] {0,2,1,-3};
		System.out.println(new Solution().threeSumClosest(arr, 1)); // 0

	}
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        /*
            a + b + c = t
            => t - a = b + c
        */

        int minDiff = Integer.MAX_VALUE;
        int sum3 = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            int sum2 = twoSum(nums, i + 1, target - nums[i]);

            int diff = difference(target, sum2 + nums[i]);
            // System.out.println("3: " + List.of(nums[i], sum2, diff));

            if (diff < minDiff) {
                minDiff = diff;
                sum3 = sum2 + nums[i];
            }
        }

        return sum3;
    }

    int twoSum(int[] nums, int start, int target) {
        /*
            a + b = t
            => b = t - a
        */
        int minDiff = Integer.MAX_VALUE;
        int sum2 = 0;

        for(int i = start; i < nums.length - 1; i++) {
            int closest = findClosest(nums, i + 1, target - nums[i]);
            int diff = difference(target, nums[i] + closest);
            // System.out.println("2: " + List.of(target, nums[i], closest));
            if (diff < minDiff) {
                minDiff = diff;
                sum2 = nums[i] + closest;
            }
        }
        // System.out.println("  2 -->> " + List.of(start, target, minDiff, sum2));
        return sum2;

    }

    int findClosest(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;

        while((right - left) > 1) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) return target;
            else if (nums[mid] > target) right = mid;
            else left = mid;
        }

        int diff1 = difference(target, nums[left]);
        int diff2 = difference(target, nums[right]);

        // System.out.println("1: " + List.of(target, nums[left], nums[right]));

        if (diff1 < diff2) return nums[left];
        else return nums[right];
    }

    int difference(int a, int b) {
        return Math.abs(Math.min(a, b) - Math.max(a, b));
    }
}
