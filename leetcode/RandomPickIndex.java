import java.util.*;

/*
	https://leetcode.com/problems/random-pick-index/
*/
class RandomPickIndex {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 3};
		Solution runner = new Solution(nums);
		System.out.println(runner.pick(3));
		System.out.println(runner.pick(1));
		System.out.println(runner.pick(3));
	}
}

class Solution {

    Map<Integer, List<Integer>> map;
    Random rand;

    public Solution(int[] nums) {
        rand = new Random();

        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());

            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        var list = map.get(target);
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
