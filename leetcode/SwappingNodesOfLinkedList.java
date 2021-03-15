/*
		https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
*/
class SwappingNodesOfLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println("Original list: ");
		printList(head);

		head = new Solution().swapNodes(head, 2);

		System.out.println("swap node by 2 : ");
		printList(head);
	}

	static void printList(ListNode head) {
		while (head != null) {
			System.out.print( head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;

        for(int i = 1; i < k; i++)
            curr = curr.next;

        ListNode left = curr;

        ListNode right = head;

        while (curr.next != null) {
            right = right.next;
            curr = curr.next;
        }

        var tmp = left.val;
        left.val = right.val;
        right.val = tmp;

        return head;

    }
}

/**
 * 	Definition for singly-linked list.
*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
