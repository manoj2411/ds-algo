/*
	https://leetcode.com/problems/binary-tree-pruning/
*/
class BinaryTreePruning {
	public static void main(String[] args) {
		var root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);

		var result = new Solution().pruneTree(root);

		// TODO: add proper way to test the result [me being lazy today]
		String msg;
		if (root != null && root.left != null && root.right == null)
			msg = "Success! pruned right subtree";
		else
			msg = "Failure!";

		System.out.println(msg);
	}
}

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return hasOne(root) ? root : null;
    }

    boolean hasOne(TreeNode node) {
        if (node == null) return false;

        var leftHasOne = hasOne(node.left);
        var rightHasOne = hasOne(node.right);

        if (leftHasOne == false) node.left = null;
        if(rightHasOne == false) node.right = null;

        return node.val == 1 || leftHasOne || rightHasOne;
    }
}

/**		Definition for a binary tree node.	*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

