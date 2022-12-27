import java.util.*;

/*
	https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
*/
class MaxBagsWithFullCapacityOfRocks {
	public static void main(String[] args) {
		int[] capacity = {2,3,4,5};
		int[] rocks = {1,2,4,4};
		int additionalCapacity = 2;
		int result = new Solution().maximumBags(capacity, rocks, additionalCapacity);
		System.out.println(result); // 3
	}
}

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int result = 0;
        PriorityQueue<Integer> pque = new PriorityQueue<>();

        for(int i = 0; i < rocks.length; i++) {
            int diff = capacity[i] - rocks[i];

            if (diff == 0) {
                result++;
            } else {
                pque.add(diff);
            }
        }

        while (additionalRocks > 0 && !pque.isEmpty()) {
            int diff = pque.poll();

            if (diff <= additionalRocks) {
                additionalRocks -= diff;
                result++;
            } else {
                break;
            }
        }

        return result;
    }
}
