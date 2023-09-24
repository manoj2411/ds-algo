/*
        https://leetcode.com/problems/champagne-tower/
*/
class ChampagneTower {
    public static void main(String[] args) {
        AlternativeSolution sol = new AlternativeSolution();
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

class AlternativeSolution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] currRow = new double[] {poured};

        for(int row = 1 ;row <= query_row; row++) {
            double[] nextRow = new double[row+1];

            for(int i = 0; i < currRow.length; i++) {
                if(currRow[i] > 1) {
                    double extra = (currRow[i] - 1) / 2;
                    nextRow[i] += extra;
                    nextRow[i+1] += extra;
                }
            }
            currRow = nextRow;
        }

        return currRow[query_glass] > 1 ? 1 : currRow[query_glass];
    }
}
