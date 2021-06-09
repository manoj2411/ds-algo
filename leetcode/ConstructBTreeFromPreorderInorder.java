/*
	https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
*/
class ConstructBTreeFromPreorderInorder {
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode root = new Solution().buildTree(preorder, inorder);
		System.out.print("Inorder: ");
		printInorder(root); // // 9,3,15,20,7
		System.out.println();
	}

	static void printInorder(TreeNode node) {
		if (node == null) return;

		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}
}

class Solution {

    int preorderi;
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderi = 0;
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0, inorder.length - 1);
    }

    TreeNode buildTree(int left, int right) {
        if (left > right) return null;

        int val = preorder[preorderi++];
        int inorderi = getIndex(inorder, val, left, right);

        var node = new TreeNode(val);

        node.left = buildTree(left, inorderi - 1);
        node.right = buildTree(inorderi + 1, right);

        return node;
    }

    int getIndex(int[] arr, int val, int left, int right) {

        for(int i = left; i <= right; i++)
            if (arr[i] == val) return i;

        return -1;
    }
}

/*	Definition for a binary tree node.  */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
