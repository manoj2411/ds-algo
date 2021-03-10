/*
		https://leetcode.com/problems/add-one-row-to-tree/
*/
class AddOneRowToTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);

		root = new Solution().addOneRow(root, 10, 3);
		printInorder(root); // 4 2 10 3 10 1
		System.out.println();
	}

	static void printInorder(TreeNode node) {
		if (node == null) return;

		System.out.print(node.val + " ");
		printInorder(node.left);
		printInorder(node.right);
	}
}

class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        return addRowAtLevel(root, v, d, 1);
    }

    private TreeNode addRowAtLevel(TreeNode root, int v, int d, int l) {
        if (root == null) return root;

        if (l + 1 == d) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        } else {
            addRowAtLevel(root.left, v, d, l + 1);
            addRowAtLevel(root.right, v, d, l + 1);
        }

        return root;
    }
}

/**
 * Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}
