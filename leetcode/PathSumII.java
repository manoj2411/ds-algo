import java.util.*;
/*
	https://leetcode.com/problems/path-sum-ii/
*/
class PathSumII {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(0);
		root.right = new TreeNode(5);

		System.out.println(new Solution().pathSum(root, 5)); // [[0, 5, 0], [0, 5]]
		System.out.println(new Solution().pathSum(root, 0)); // []
	}
}

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();

        pathSum(root, targetSum, currPath, result);
        return result;
    }

    void pathSum(TreeNode node, int target, List<Integer> currPath, List<List<Integer>> result) {
        if (node == null) return;

        if (node.left == null && node.right == null) {

            if (target == node.val) {
                List<Integer> path = new ArrayList<>(currPath);
                path.add(node.val);
                result.add(path);
            }
            return;
        }

        currPath.add(node.val);
        pathSum(node.left, target - node.val, currPath, result);
        pathSum(node.right, target - node.val, currPath, result);
        currPath.remove(currPath.size() - 1);
    }
}

/**		Definition for a binary tree node.	 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
