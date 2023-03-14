/*
	https://leetcode.com/problems/sum-root-to-leaf-numbers/
*/
class SumRootToLeafNumbers {
	public static void main(String[] args) {
		var root = new TreeNode (4);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(0);

		System.out.println(new SolutionWithIntPath().sumNumbers(root)); // 1026
	}
}


class SolutionWithIntPath {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int path) {
        if (node == null) {
            return 0;
        }

        int newPath = (path * 10) + node.val;
        if (isLeaf(node))  {
            return newPath;
        }

        return helper(node.left, newPath) + helper(node.right, newPath);
    }
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

class SolutionWithStrPath {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, new StringBuilder());
        return sum;
    }

    private void helper(TreeNode root, StringBuilder str) {
        if (root == null) return;
        else if (root.left == null && root.right == null) {
            str.append(root.val);
            sum += Integer.valueOf(str.toString());
            str.setLength(str.length() - 1);
            return;
        }

        str.append(root.val);
        helper(root.left, str);
        helper(root.right, str);
        str.setLength(str.length() - 1);
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
