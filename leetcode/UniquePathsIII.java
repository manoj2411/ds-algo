import java.util.*;

/*      https://leetcode.com/problems/unique-paths-iii/    */
class UniquePathsIII {

    static class Solution {
        int result;
        public int uniquePathsIII(int[][] grid) {
            result = 0;
            if(onlyStartAndEnd(grid)) return 1;

            int[] start = findStart(grid);

            List<int[]> nextSteps = findNextSteps(grid, start[0], start[1]);
            // System.out.println("nextSteps: " + nextSteps.size());
            for(int[] nextPosition : nextSteps) {
                int r = nextPosition[0];
                int c = nextPosition[1];
                // System.out.println("r, c: " + r + ", " + c);
                visit(grid, r, c);
            }
            return result;
        }

        void visit(int[][] grid, int r, int c) {
            if(grid[r][c] == 2) {
                if(isValidPath(grid)) result++;
                return;
            }

            grid[r][c] = 7; // mark visited

            List<int[]> nextSteps = findNextSteps(grid, r, c);
            for(int[] nextPosition : nextSteps) {
                int next_r = nextPosition[0];
                int next_c = nextPosition[1];
                visit(grid, next_r, next_c);
            }

            grid[r][c] = 0; // unmark visited
        }

        boolean isValidPath(int[][] grid) {
            for(int i = 0; i< grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 0) return false;
                }
            }
            return true;
        }

        List<int[]> findNextSteps(int[][] grid, int r, int c) {
            List<int[]> result = new ArrayList<>();
            int M = grid.length;
            int N = grid[0].length;
            if(r + 1 < M && (grid[r+1][c] == 0 || grid[r+1][c] == 2)) {
                int[] nextStep = {r+1, c};
                result.add(nextStep);
            }
            if(r - 1 >= 0 && (grid[r-1][c] == 0 || grid[r-1][c] == 2)) {
                int[] nextStep = {r-1, c};
                result.add(nextStep);
            }
            if(c + 1 < N && (grid[r][c+1] == 0 || grid[r][c+1] == 2)) {
                int[] nextStep = {r, c+1};
                result.add(nextStep);
            }
            if(c - 1 >= 0 && (grid[r][c-1] == 0 || grid[r][c-1] == 2)) {
                int[] nextStep = {r, c-1};
                result.add(nextStep);
            }
            return result;
        }

        int[] findStart(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 1) {
                        int[] start = {i, j};
                        return start;
                    }
                }
            }
            int[] start = {};
            return start;
        }

        boolean onlyStartAndEnd(int[][] grid) {
            return (grid.length == 1 && grid[0].length == 2) || (grid.length == 2 && grid[0].length == 1);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println("result: " + sol.uniquePathsIII(grid1)); // 2

        int[][] grid2 = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println("result: " + sol.uniquePathsIII(grid2)); // 4

        /*  Test cases :

            [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
            [[0,0,0,0],[0,1,0,0],[0,0,2,-1]]
            [[1,2]]
            [[1],[2]]
            [[1,0,-1,2]]
            [[1,0,2]]
            [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
            [[0,1],[2,0]]
        */
    }
}
