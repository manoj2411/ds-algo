/*
	https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
*/
class ConvertSortedListToBST {
	public static void main(String[] args) {
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
		TreeNode root = new Solution().sortedListToBST(head);
		printPreorder(root);
		System.out.println();
	}
	static void printPreorder(TreeNode root) {
		if (root == null) return;
		printPreorder(root.left);
		System.out.print(root.val + " ");
		printPreorder(root.right);
	}
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null) {
            fast = fast.next;

            if (fast == null || fast.next == null) break;
            fast = fast.next;
            slow = slow.next;
        }

        ListNode right = slow.next.next;
        TreeNode root = new TreeNode(slow.next.val);
        slow.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(right);

        return root;
    }
}

/*	Definition for singly-linked list.	*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

/*	Definition for a binary tree node. 	 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
