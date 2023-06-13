import java.util.*;

/*
	https://leetcode.com/problems/equal-row-and-column-pairs/description/
*/
class EqualRowandColumnPairs {
	public static void main(String args[]) {
		int[][] grid = {
			{3,1,2,2},
			{1,4,4,5},
			{2,4,2,2},
			{2,4,2,2}
		};
		System.out.println(new Solution().equalPairs(grid)); // 3
	}
}

class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> keyCount = new HashMap<>();

        for(int[] row : grid) {
            String key = Arrays.toString(row);
            keyCount.put(key, 1 + keyCount.getOrDefault(key, 0));
        }

        int samePairs = 0;
        int[] col = new int[grid.length];
        for(int c = 0; c < grid.length; c++) {
            for(int row = 0; row < grid.length; row++) {
                col[row] = grid[row][c];
            }
            String key = Arrays.toString(col);
            samePairs += keyCount.getOrDefault(key, 0);
        }

        return samePairs;
    }
}
