/*
    https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
*/

class MinCostToMoveChips {
   static int minCostToMoveChips(int[] position) {
        int placedAtEven = 0;
        int placedAtOdd = 0;
        for(int pos : position) {
            if(pos % 2 == 0) {
                placedAtEven++;
            } else {
                placedAtOdd++;
            }
        }
        return Math.min(placedAtEven, placedAtOdd);
    }

    public static void main(String[] args) {
        int[][] inputs = {
            {1,2,3}, // 1
            {2,3,2,3,2}, // 2
            {3,2,3,2,3}, // 2
            {1,100000000} // 1
        };

        for(int[] positions : inputs) {
            System.out.println(minCostToMoveChips(positions));
        }
    }
}
