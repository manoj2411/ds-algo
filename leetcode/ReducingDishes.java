import java.util.*;

/*
    https://leetcode.com/problems/reducing-dishes/description/
*/

class ReducingDishes {
    public static void main(String[] args) {
        int[] arr = {-1,-8,0,5,-9};
        System.out.println(new Solution().maxSatisfaction(arr)); // 14

        arr = new int[] {4,3,2};
        System.out.println(new Solution().maxSatisfaction(arr)); // 20

        arr = new int[] {-1,-4,-5};
        System.out.println(new Solution().maxSatisfaction(arr)); // 0
    }
}


class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int len = satisfaction.length;
        int maxLikeTime = 0;

        for(int i = 0; i < len; i++) {

            int currLikeTime = 0;
            for(int j = i, c = 1; j < len; j++, c++) {
                currLikeTime += c * satisfaction[j];
            }

            maxLikeTime = Math.max(maxLikeTime, currLikeTime);

            if (satisfaction[i] >= 0) {
                break;
            }
        }

        return maxLikeTime;
    }
}
