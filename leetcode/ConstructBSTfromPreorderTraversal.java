/*
	https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
*/
class ConstructBSTfromPreorderTraversal {
	public static void main(String[] args) {
		int[] preorder = { 1, 3};
		TreeNode root = new Solution().bstFromPreorder(preorder);
		System.out.println("root: " + root.val); // 1
		System.out.println("left: " + root.left); // null
		System.out.println("right: " + root.right.val); // 3
	}
}

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for(int i = 1; i < preorder.length; i++) {
            addToBST(root, preorder[i]);
        }
        return root;
    }

    private TreeNode addToBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        else if (val < root.val)
            root.left = addToBST(root.left, val);
        else
            root.right = addToBST(root.right, val);

        return root;
    }
}

/**	Definition for a binary tree node.	 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
