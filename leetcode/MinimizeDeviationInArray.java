import java.util.*;

/*
	https://leetcode.com/problems/minimize-deviation-in-array/description/
*/
class MinimizeDeviationInArray {
	public static void main(String[] args) {
		System.out.println(new Solution().minimumDeviation(new int[] {1,2,3,4})); // 1
		System.out.println(new Solution().minimumDeviation(new int[] {4,1,5,20,3})); // 3
		System.out.println(new Solution().minimumDeviation(new int[] {5, 3})); // 1
	}
}


class Solution {

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
        int min = Integer.MAX_VALUE;
        for(int num :  nums) {
            if (num % 2 == 1) { // double all odds to make them to simplify the operations to only 1
                num *= 2;
            }
            maxHeap.add(num);
            min = Math.min(min, num);
        }

        int minDiff = Integer.MAX_VALUE;
        while(true) {
            int max = maxHeap.poll();

            minDiff = Math.min(minDiff, max - min);

            if (max % 2 == 1) {
            	break;
            } else {
            	max /= 2;
            }

            min = Math.min(min, max);
            maxHeap.add(max);
        }

        return minDiff;
    }
}
