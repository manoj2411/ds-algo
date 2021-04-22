import java.util.*;

/*
	https://leetcode.com/problems/triangle/
*/
class Triangle {
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(List.of(2));
		triangle.add(List.of(3,4));
		triangle.add(List.of(6,5,7));
		triangle.add(List.of(4,1,8,3));

		System.out.println(new Solution().minimumTotal(triangle)); // 11

	}
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] minPathSum = {triangle.get(0).get(0)};

        if (triangle.size() == 1) return minPathSum[0];

        for(int i = 0; i < triangle.size() - 1; i++) {

            int[] nextRowMinPathSum = new int[i+2];
            for(int j = 0; j < i + 2; j++)
                nextRowMinPathSum[j] = Integer.MAX_VALUE;

            var nextRowItems = triangle.get(i+1);

            for(int j = 0; j < minPathSum.length; j++) {

                nextRowMinPathSum[j] =
                	Math.min(
                		nextRowMinPathSum[j],
                		minPathSum[j] + nextRowItems.get(j));

                nextRowMinPathSum[j+1] = minPathSum[j] + nextRowItems.get(j+1);
            }

            // System.out.println(Arrays.toString(nextRowMinPathSum));

            minPathSum = nextRowMinPathSum;
        }

        return getMin(minPathSum);
    }

    int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int n : arr)  min = Math.min(min, n);
        return min;
    }
}
