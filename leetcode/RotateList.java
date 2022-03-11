/*
    https://leetcode.com/problems/rotate-list/
*/
class RotateList {
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(7);

		System.out.println("Original list ");
		printList(head);
		System.out.println("Left rotate by 2 ");
		printList(new Solution().rotateRight(head, 2)); // [6,7,2,4]
	}

	private static void printList(ListNode head) {
		while ( head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();

	}
}



class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode  tail = head;
        int length = 1;

        while(tail.next != null) {
            tail = tail.next;
            length++;
        }

        if (k % length == 0) return head;

        ListNode newTail = head;
        for(int i = 1; i < length - (k % length) ; i++) {
            newTail = newTail.next;
        }

        tail.next = head;
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}

/**
 * Definition for singly-linked list.
*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}
