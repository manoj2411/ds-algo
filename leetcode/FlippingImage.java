import java.util.*;

class FlippingImage {

    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        Solution sol = new Solution();
        int[][] inverted = sol.flipAndInvertImage(image);
        // [1,0,0],[0,1,0],[1,1,1]
        for(int[] row : inverted)
            System.out.println(Arrays.toString(row));

    }
}

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[] invert = {1,0};

        for(int[] row : A) {

            for(int l = 0, r = row.length - 1; l <= r; l++, r--) {
                int li = invert[row[l]];
                int ri = invert[row[r]];
                row[l] = ri;
                row[r] = li;
            }
        }

        return A;
    }
}
