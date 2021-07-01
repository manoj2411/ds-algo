/*
	https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/
class LowestCommonAncestorOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);

		System.out.println(
			new Solution().lowestCommonAncestor(root, root.left, root.right).val); // 3
	}
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}

/**	Definition for a binary tree node. 	 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
