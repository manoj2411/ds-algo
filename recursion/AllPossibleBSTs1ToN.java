import java.util.*;

/*
	https://leetcode.com/problems/unique-binary-search-trees-ii/
*/
class AllPossibleBSTs1ToN {
	public static void main(String[] args) {
		System.out.println("BSTs for 3 : ");

		for(TreeNode root : new Solution().generateTrees(3)) {
			System.out.print("Inorder: ");
			printInorder(root);
			System.out.println();
		}
	}

	static void printInorder(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val + " ");
		printInorder(root.left);
		printInorder(root.right);
	}
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new ArrayList<TreeNode>();

        return helper(1, n);
    }

    List<TreeNode> helper(int l, int r) {
        List<TreeNode> res = new LinkedList<>();

        if(l == r) {
            res.add(new TreeNode(l));
            return res;
        }
        for(TreeNode right : helper(l + 1, r)) {
            TreeNode curr = new TreeNode(l);
            curr.right = right;
            res.add(curr);
        }

        for(int i = l + 1; i < r; i++) {
            for(TreeNode left : helper(l, i - 1)) {
                for(TreeNode right : helper(i + 1, r)) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = left;
                    curr.right = right;
                    res.add(curr);
                }
            }
        }

        for(TreeNode left : helper(l, r - 1)) {
            TreeNode curr = new TreeNode(r);
            curr.left = left;
            res.add(curr);
        }

        return res;

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

