/*
		https://leetcode.com/problems/increasing-order-search-tree/
*/
class IncreasingOrderSearchTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(7);
		Solution sol = new Solution();
		root = sol.increasingBST(root);
		System.out.print("Tree (root to right): " + root.val + ", ");
		System.out.print(root.right.val + ", ");
		System.out.println(root.right.right.val);
	}
}

class Solution {
    TreeNode prev;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode();
        prev = dummy;

        helper(root);
        return dummy.right;
    }

    void helper(TreeNode root) {
        if(root == null) return;

        helper(root.left);

        root.left = null;
        prev.right = root;
        prev = root;

        helper(root.right);
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
