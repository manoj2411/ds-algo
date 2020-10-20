/*
        https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
*/
class MinDominoRotations {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};
        // Output: 2
        System.out.println("Res: " + sol.minDominoRotations(A, B));

        int[] A1 = {3,5,1,2,3};
        int[] B1 = {3,6,3,3,4};
        // Output: -1
        System.out.println("Res: " + sol.minDominoRotations(A1, B1));
    }
}

class Solution {
    public int minDominoRotations(int[] A, int[] B) {

        for(int i = 1; i <= 6 ; i++) {
            int res = tryWith(A, B, i);

            if(res >= 0)
                return res;
        }

        return -1;
    }

    int tryWith(int[] A, int[] B, int x) {
        int acount = 0;
        int bcount = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] != x && B[i] != x) {
                return -1;
            } else if(A[i] != x) {
                acount += 1;
            } else if(B[i] != x) {
                bcount += 1;
            }
        }
        return Math.min(acount, bcount);
    }
}
