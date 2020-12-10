import java.util.*;
/*
	https://leetcode.com/problems/binary-search-tree-iterator/
*/
class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        add(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        add(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }

    private void add(TreeNode root) {
        if(root == null) return;

        TreeNode curr = root;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }


	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);

		BSTIterator iterator = new BSTIterator(root);
		while(iterator.hasNext())
			System.out.print(iterator.next() + " ");
		System.out.println();
	}
}

/**
* Your BSTIterator object will be instantiated and called as such:
* BSTIterator obj = new BSTIterator(root);
* int param_1 = obj.next();
* boolean param_2 = obj.hasNext();
*/

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
