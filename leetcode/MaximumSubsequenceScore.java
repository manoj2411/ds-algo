import java.util.*;

/*
	https://leetcode.com/problems/maximum-subsequence-score/description/
*/
class MaximumSubsequenceScore {
	public static void main(String[] args) {
		int[] nums1 = {1,3,3,2};
		int[] nums2 = {2,1,3,4};
		System.out.println(new Solution().maxScore(nums1, nums2, 3)); // 12

		nums1 = new int[] {4,2,3,1,1};
		nums2 = new int[] {7,5,10,9,6};
		System.out.println(new Solution().maxScore(nums1, nums2, 1)); // 30

		nums1 = new int[] {2,1,14,12};
		nums2 = new int[] {11,7,13,6};
		System.out.println(new Solution().maxScore(nums1, nums2, 3)); // 168
	}
}

class Solution {

    record Pair(int num1, int num2) {};

    public long maxScore(int[] nums1, int[] nums2, final int k) {
        int len = nums1.length;
        Pair[] pairs = new Pair[len];
        for(int i = 0; i < len; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }
        sort(pairs);

        long sum = 0;
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            sum += pairs[i].num1;
            pque.add(pairs[i].num1);
        }

        long max = sum * pairs[k-1].num2;

        for(int r = k, l = 0; r < len; r++, l++) {
            sum -= pque.poll();
            sum += pairs[r].num1;
            pque.add(pairs[r].num1);
            max = Math.max(max, sum * pairs[r].num2);
        }

        return max;
    }

    private void sort(Pair[] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a.num2 == b.num2) {
                return -Integer.compare(a.num1, b.num1);
            }
            return -Integer.compare(a.num2, b.num2);
        });
    }
}
