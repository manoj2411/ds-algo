/*
		https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*/
class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);

		new Solution().flatten(root);

		printRight(root);
	}

	static void printRight(TreeNode node) {
		var curr = node;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.right;
		}
		System.out.println();
	}
}

class Solution {
    TreeNode prev;

    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode();
        prev = dummy;

        preorder(root);

    }

    private void preorder(TreeNode node) {
        if (node == null) return;

        var right = node.right;

        prev.right = node;
        prev.left = null;
        prev = node;

        preorder(node.left);
        preorder(right);
    }
}

/*	Definition for a binary tree node.	*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
