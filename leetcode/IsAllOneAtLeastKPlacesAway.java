/*
    https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
*/
class IsAllOneAtLeastKPlacesAway {
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,0,1};
        int k = 2;
        System.out.println(new Solution().kLengthApart(nums, k)); // true
        System.out.println(new Solution().kLengthApart(nums, 3)); // false
    }
}

class Solution {
    public boolean kLengthApart(int[] nums, int k) {

        int last = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                last = i;
                break;
            }
        }

        if(last == -1) return true;

        for(int i = last + 1; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(i - (last + 1) < k) return false;
                last = i;
            }
        }

        return true;
    }
}
