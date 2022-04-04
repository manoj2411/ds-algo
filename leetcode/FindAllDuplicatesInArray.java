import java.util.*;

/*
	https://leetcode.com/problems/find-all-duplicates-in-an-array/
*/
class FindAllDuplicatesInArray {
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(new Solution().findDuplicates(nums)); // [2, 3]

		nums = new int[] {1,1,2};
		System.out.println(new Solution().findDuplicates(nums)); // [1]
	}
}


class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                result.add(index+1);
            nums[index] *= -1;
        }

        return result;
    }
}
