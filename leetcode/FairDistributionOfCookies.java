/*
	https://leetcode.com/problems/fair-distribution-of-cookies/description/
*/
class FairDistributionOfCookies {
	public static void main(String... args) {
		int[] cookies = {8,15,10,20,8};
		System.out.println(new Solution().distributeCookies(cookies, 2)); // 31
	}
}

class Solution {

    int min = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        backtrack(cookies, children, 0);
        return min;
    }

    private void backtrack(int[] cookies, int[] children, int index) {
        if (index == cookies.length) {
            min = Math.min(min, findMax(children));
            return;
        }

        for(int i = 0; i < children.length; i++) {
            children[i] += cookies[index];
            backtrack(cookies, children, index + 1);
            children[i] -= cookies[index];
        }

    }

    private int findMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
