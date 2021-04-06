/*
	https://leetcode.com/problems/global-and-local-inversions/
*/
class GlobalAndLocalInversions {
	public static void main(String[] args) {
		int[] arr = {1,0,2}; // true
		System.out.println(new Solution().isIdealPermutation(arr));

		arr = new int[] {1,2,0}; // false
		System.out.println(new Solution().isIdealPermutation(arr));

		arr = new int[] {1, 0, 3, 2}; // true
		System.out.println(new Solution().isIdealPermutation(arr));

		arr = new int[] {5, 0, 4, 1, 2, 3}; // false
		System.out.println(new Solution().isIdealPermutation(arr));
	}
}

class Solution {
    public boolean isIdealPermutation(int[] A) {
        int min = A[A.length - 1];

        for(int i = A.length - 3; i >= 0; i--) {

            if ( (A[i] > A[i+1] && A[i] > min) || (A[i+1] > A[i] && A[i] > min ))
                return false;

            min = Math.min(min, A[i+1]);
        }

        return true;
    }
}
