/*
    https://leetcode.com/problems/number-of-closed-islands/
*/
class NumberOfClosedIslands {
    public static void main(String[] args) {

    }
}

/*
    This solution is based on a different flavor of union-find with DFS.
    Another simple intuitive solution could be based on floodFill.
*/
class Solution {

    int[][] grid;
    int rowLength;
    int colLength;
    Map<Integer, Boolean> groupMap = new HashMap<>();

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.rowLength = grid.length;
        this.colLength = grid[0].length;
        int closedIslands = 0;
        int label = 2;

        for(int row = 0; row < rowLength; row++) {
            for(int col = 0; col < colLength; col++) {
                if (grid[row][col] == 0) {

                    groupMap.put(label, true);
                    dfs(row, col, label);
                    if (groupMap.get(label)) {
                        closedIslands++;
                    }
                    label++;
                }
            }
        }
        return closedIslands;
    }

    private static final int[][] DIRECTIONS = { {-1,0}, {1,0}, {0,-1}, {0,1}};

    private void dfs(int row, int col, int label) {
        if (row == rowLength || row < 0 || col == colLength || col < 0) {
            groupMap.put(label, false);
            return;
        }


        if (grid[row][col] == 0) {
            grid[row][col] = label;
            for(int[] dir : DIRECTIONS) {
                int r = row + dir[0];
                int c = col + dir[1];
                dfs(r, c, label);
            }
        }

    }

}
