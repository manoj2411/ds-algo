import java.util.*;

/*
	https://leetcode.com/problems/making-a-large-island/
*/
class MakingALargeIsland {
	public static void main(String[] args) {
		int[][] grid = {
			{0,0,1,0,0},
			{1,1,0,1,1},
			{0,0,1,0,0},
			{0,0,0,0,0},
			{0,1,1,1,1}};
		System.out.println(new Solution().largestIsland(grid)); // 7
	}
}


class Solution {
    private static int[][] DIRECTIONS = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int[][] groups;
    private int[][] grid;
    private int N;

    public int largestIsland(int[][] grid) {

        this.N = grid.length;
        this.groups = new int[N][N];
        this.grid = grid;

        List<Integer> count = new ArrayList<>();
        count.add(0);

        int label = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (grid[i][j] == 1 && groups[i][j] == 0) {

                    int size = markIsland(i, j, ++label);
                    // System.out.println("label and size : " + List.of(label, size));
                    count.add(size);
                }
            }
        }

        int largestIslandSize = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    int joinedIslandsSize = findNeighboringIslandSum(i, j, count);
                    largestIslandSize = Math.max(largestIslandSize, joinedIslandsSize);
                }
            }
        }

        return Math.max(largestIslandSize, count.get(count.size() - 1));
    }

    private int markIsland(int i, int j, int label) {
        int size = 1;
        groups[i][j] = label;

        for(int[] dir : DIRECTIONS) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < N && c >= 0 && c < N && grid[r][c] == 1 && groups[r][c] == 0) {
                size += markIsland(r, c, label);
            }
        }

        return size;
    }

    private int findNeighboringIslandSum(int i, int j, List<Integer> count) {
        int size = 1;
        Set<Integer> islands = new HashSet<>();

        for(int[] dir : DIRECTIONS) {

            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && r < N && c >= 0 && c < N && grid[r][c] == 1) {
                islands.add(groups[r][c]);
            }
        }

        for(int island : islands) {
            size += count.get(island);
        }

        return size;
    }
}
