/*
	https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
*/
class VerifyPreorderSerializationofBinTree {
	public static void main(String[] args) {
		System.out.println(
			new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")); // true

		System.out.println(new Solution().isValidSerialization("9,#,#,1")); // false

		System.out.println(new Solution().isValidSerialization("24,#")); // false

		System.out.println(
			new Solution().isValidSerialization("1,2,33,44,#,#,#,#,5,#,6,#,7,8,#,#,#")); // true

	}
}

class Solution {
	/*
		The idea is to start cancelling leaf nodes from the end of the string
		 replace num, #, # with a # and go on, at the end of processing we must
		 have only one # in case of a valid tree serialization.
	*/
    public boolean isValidSerialization(String preorder) {
        int separators = 0;

        String[] nodes = preorder.split(",");

        for(int i = nodes.length - 1; i >= 0; i--) {

            if (nodes[i].equals("#")) {
                separators++;
            } else {
                if (separators < 2) return false;
                separators--;
            }

        }

        return separators == 1;
    }
}
