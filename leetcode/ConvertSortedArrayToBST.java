import java.util.*;
/*
	https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
*/
class ConvertSortedArrayToBST {
	public static void main(String[] args) {
		int[] arr = {-10,-3,0,5,9};

		TreeNode root = new Solution().sortedArrayToBST(arr);


		System.out.println(toPreorderList(root));
	}


	static void toPreorderList(TreeNode root, List<Integer> list) {
		if (root == null) return;
		toPreorderList(root.left, list);
		list.add(root.val);
		toPreorderList(root.right, list);
	}

	static List<Integer> toPreorderList(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		toPreorderList(root, list);
		return list;

	}
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);

        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);

        return node;
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

