/*
	https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
*/
class PseudoPalindromicPathsBinTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);

		// res : 2
		System.out.println("pseudo-palindromic paths: " +
			new Solution().pseudoPalindromicPaths(root));
	}
}

class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] counts = new int[10];
        return helper(root, counts);
    }

    int helper(TreeNode node, int[] counts) {
        if(node == null)
            return 0;

        counts[node.val]++;

        if(node.left == null && node.right == null) {
            int odds = 0;
            for(int n : counts) {
                if(n % 2 == 1)
                    odds++;
            }
            counts[node.val]--;
            return odds <= 1 ? 1 : 0;
        }

        int left = helper(node.left, counts);
        int right = helper(node.right, counts);
        counts[node.val]--;

        return left + right;

    }
}

/*
* 	Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
