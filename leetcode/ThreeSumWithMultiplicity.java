/*
    https://leetcode.com/problems/3sum-with-multiplicity/
*/
class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        System.out.println(new Solution().threeSumMulti(arr, 8)); // 20

        arr = new int[] {1,1,2,2,2,2};
        System.out.println(new Solution().threeSumMulti(arr, 5)); // 12
    }
}

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long result = 0;

        for(int i = 0; i < arr.length - 2; i++) {
            result += twoSumMulti(arr, i + 1, target - arr[i]);
        }

        return (int)(result % 1000000007);
    }

    private long twoSumMulti(int[] arr, int start, int target) {
        int[] counter = new int[101];

        long result = 0;
        for(int i = start; i < arr.length; i++) {
            int k = target - arr[i];
            if (k >= 0 && k <= 100 && counter[k] > 0) {
                result += counter[k];
            }
            counter[arr[i]]++;
        }
        return result;
    }
}
