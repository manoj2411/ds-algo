/*
	https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/
class RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		var head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);

		var newHead = new Solution().removeNthFromEnd(head, 2);

		printList(newHead); // 2, 6
	}

	static void printList(ListNode head) {
		while ( head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();

	}
}

/*
	complexity of solution

		time:	O(1) [single pass]
		space: 	O(1)

	Algorithm: take 2 pointers left and right, move right n times then move both left and right
	  until right reaches to the end node, than left's next will be the node to be removed.
	  But there is a special case when n == length of the list which means we need to remove
	  head node now, to handle it we simply check if right is null then remove head & return.
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        ListNode left = head;

        for(int i = 0; i < n; i++)
            right = right.next;

        if (right == null) return head.next;

        while(right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;
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
