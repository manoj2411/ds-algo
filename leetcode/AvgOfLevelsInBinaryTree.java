import java.util.*;

/*
	https://leetcode.com/problems/average-of-levels-in-binary-tree/
*/
class AvgOfLevelsInBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(new Solution().averageOfLevels(root)); // [3, 14.5, 11]
	}
}

class Solution {

	/*
		complexity of solution
			time : 	O(N)
			space : O(N)
	*/

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> values = new ArrayList<>();

        preorder(root, 0, values);

        List<Double> result = new ArrayList<>();
        for(int i = 0; i < values.size(); i++) {
            long total = 0;
            for(int n : values.get(i))
                total += n;

            result.add((double)total / values.get(i).size() );
        }

        return result;

    }

    private void preorder(TreeNode root, int level, List<List<Integer>> values) {
        if (root == null) return;

        if (values.size() == level) {
            values.add(new ArrayList<>());
        }

        values.get(level).add(root.val);

        preorder(root.left, level + 1, values);
        preorder(root.right, level + 1, values);

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
