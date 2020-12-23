/*
	https://leetcode.com/problems/balanced-binary-tree/
*/
class BalancedBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		Solution sol = new Solution();
		// res: true
		System.out.println("Is tree balanced? : " + sol.isBalanced(root));
	}
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean[] res = {true};
        height(root, res);
        return res[0];
    }

    int height(TreeNode root, boolean[] res) {
        if(root == null) return 0;

        int lsize = height(root.left, res);
        int rsize = height(root.right, res);

        if(Math.abs(lsize - rsize) > 1)
            res[0] = false;

        return Math.max(lsize, rsize) + 1;
    }
}

/**
* Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
