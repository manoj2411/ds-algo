import java.util.*;

/*
	https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
*/
class FindAllNumbersDisappearedInArray {
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(new Solution().findDisappearedNumbers(nums)); // [5,6]

		nums = new int[] {1,1};
		System.out.println(new Solution().findDisappearedNumbers(nums)); // [2]
	}
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            int indx = Math.abs(nums[i]) % len;

            if (nums[indx] > 0)
                nums[indx] *= -1;
        }

        List<Integer> result = new ArrayList<>();

        for(int num = 1; num <= len; num++) {
            if (nums[num % len] > 0) result.add(num);
        }

        return result;
    }
}
