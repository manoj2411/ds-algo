import java.util.*;

/*
		https://leetcode.com/problems/4sum/
*/

class FourSum {
	public static void main(String[] args) {
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		System.out.println(new Solution().fourSum(nums, target));
		// [[-2, 0, 0, 2], [-2, -1, 1, 2], [-1, 0, 0, 1]]
	}
}

class Solution {

    Set<List<Integer>> result = new HashSet<>();
    Map<Integer, Integer> indices = new HashMap<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++)
            indices.put(nums[i], i);

        for(int i = 0; i < nums.length - 3; i++) {
            threeSum(nums, i + 1, target - nums[i], nums[i]);
        }

        List<List<Integer>> r = new ArrayList<>(result);
        return r;
    }

    void threeSum(int[] nums, int start, int target, int a) {

        for(int i = start; i < nums.length - 2; i++)
            twoSum(nums, i + 1, target - nums[i], List.of(a, nums[i]));

    }


    void twoSum(int[] nums, int start, int target, List<Integer> selected) {

        for(int i = start; i < nums.length - 1; i++) {
            int diff = target - nums[i];

            if (indices.containsKey(diff) && indices.get(diff) > i) {
                List<Integer> quadruplet = new ArrayList<>();
                quadruplet.addAll(selected);
                quadruplet.add(nums[i]);
                quadruplet.add(nums[indices.get(diff)]);

                result.add(quadruplet);
            }
        }
    }
}
