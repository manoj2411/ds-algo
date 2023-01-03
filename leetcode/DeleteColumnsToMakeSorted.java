/*
	https://leetcode.com/problems/delete-columns-to-make-sorted/description/
*/
class DeleteColumnsToMakeSorted {
	public static void main(String[] args) {

		String[] strs = {"cba","daf","ghi"};
		System.out.println(new Solution().minDeletionSize(strs)); // 1

		strs = new String[] {"a","b"};
		System.out.println(new Solution().minDeletionSize(strs)); // 0

		strs = new String[] {"zyx","wvu","tsr"};
		System.out.println(new Solution().minDeletionSize(strs)); // 3
	}
}

class Solution {
    public int minDeletionSize(String[] strs) {

        int columnsToRemove = 0;

        for(int c = 0; c < strs[0].length(); c++) {
            for(int i = 1; i < strs.length; i++) {
                if(strs[i-1].charAt(c) > strs[i].charAt(c)) {
                    columnsToRemove++;
                    break;
                }
            }
        }

        return columnsToRemove;
    }
}
