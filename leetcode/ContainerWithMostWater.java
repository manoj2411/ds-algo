/*
    https://leetcode.com/problems/container-with-most-water/
*/
class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height)); // 49
        height = new int[] {1,1};
        System.out.println(new Solution().maxArea(height)); // 1
    }
}

class Solution {
    /*
        The intuition is to keep 2 pointer on both ends, calculate current possible
        result using distance between them, and move pointer greedily by choosing
        the pointer that is pointing to less value. This will because with current
        values we already captured the result, moving away with pointer with less
        value we loose nothing but possibly move towards better result in linear time.
    */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int result = 0;
        while(left < right) {
            int curr = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, curr);

            if (height[left] < height[right]) left++;
            else right--;
        }

        return result;
    }
}
