import java.util.*;

/*
	https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
*/
class MaxAreaAfterHorizontalVerticalCuts {
	public static void main(String[] args) {
		int h = 5, w = 4;
		int[] horizontalCuts = {1,2,4};
		int[] verticalCuts = {1,3};
		System.out.println(new Solution().maxArea(h, w, horizontalCuts, verticalCuts)); // 4
	}
}

class Solution {

    private static long LIMIT = (long)1e9 + 7;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        long maxHorizontalGap = maxGapBetweenElements(horizontalCuts, h);
        long maxVerticalGap = maxGapBetweenElements(verticalCuts, w);

        long res = maxHorizontalGap * maxVerticalGap;

        return (int)(res % LIMIT);
    }

    long maxGapBetweenElements(int[] arr, int last) {
        Arrays.sort(arr);

        long max = 0;
        long prev = 0;

        for(long e : arr) {
            max = Math.max(max, e - prev);
            prev = e;
        }

        max = Math.max(max, last - prev);

        return max;

    }

}
