import java.util.*;

/*
	https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/
*/
class MinimumRoundsToCompleteAllTasks {
	public static void main(String[] args) {
		int[] tasks = {2,2,3,3,2,4,4,4,4,4};
		System.out.println(new Solution().minimumRounds(tasks)); // 4

		tasks = new int[] {3,2,3};
		System.out.println(new Solution().minimumRounds(tasks)); // -1
	}
}

class Solution {
    public int minimumRounds(int[] tasks) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int task : tasks) {
            map.put(task, 1 + map.getOrDefault(task, 0));
        }

        for(int count : map.values()) {
            if (count == 1) {
                return -1;
            } else {
                result += count / 3;
                if (count % 3 != 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
