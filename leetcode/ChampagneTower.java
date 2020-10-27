/*
        https://leetcode.com/problems/champagne-tower/
*/
class ChampagneTower {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.champagneTower(1,1,1)); // 0
        System.out.println(sol.champagneTower(2,1,1)); // 0.5
        System.out.println(sol.champagneTower(100000009,33,17)); // 1.0
    }
}

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] store = new double[query_row+2][query_row+2];
        store[0][0] = (double)poured;

        for(int r = 0; r <= query_row; r++) {
            for(int j = 0; j <= r; j++) {
                if(store[r][j] > 1) {
                    store[r+1][j] += (store[r][j] - 1) / 2;
                    store[r+1][j+1] += (store[r][j] - 1) / 2;
                    store[r][j] = 1.0;
                }
            }
        }
        return store[query_row][query_glass];
    }
}
