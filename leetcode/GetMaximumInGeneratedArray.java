/*
    https://leetcode.com/problems/get-maximum-in-generated-array/
*/
class GetMaximumInGeneratedArray {
    public static void main(String[] args) {

        System.out.println("When n is 7 : " +
            new Solution().getMaximumGenerated(7)); // 3
        System.out.println("When n is 100 : " +
            new Solution().getMaximumGenerated(100)); // 21
    }
}

class Solution {
    public int getMaximumGenerated(int n) {
        if(n <= 1) return n;

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;

        for(int i = 1; i <= n / 2 ; i++) {
            arr[i*2] = arr[i];

            if((i*2) + 1 <= n) {
                arr[(i*2) + 1] = arr[i] + arr[i + 1];
                max = Math.max(max, arr[i] + arr[i+1]);
            }

        }
        return max;
    }
}
