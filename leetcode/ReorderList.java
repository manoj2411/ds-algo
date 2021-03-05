/*
	https://leetcode.com/problems/reorder-list/
*/

class ReorderList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		System.out.println("Original list: ");
		printList(head);

		new Solution().reorderList(head);

		System.out.println("Reordered list: ");
		printList(head);

	}

	static void printList(ListNode head) {

		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}
}


class Solution {

	/* complexity of solution:

		time: 	O(N)
		space: 	O(1)
			Note, currently reverse method is using call stack which makes it
			O(n) space solution.
			We can easily replace reverse O(1) implementation to improvise it.
	*/

    public void reorderList(ListNode head) {

        int len = findLength(head);

        if (len <= 2) return;

        int mid = (len % 2 == 0) ? (len / 2) : (len / 2) + 1;

        ListNode curr = head;
        for(int i = 1; i < mid; i++)
            curr = curr.next;

        ListNode head2 = reverse(curr.next);
        curr.next = null;

        mergeAlt(head, head2);

    }

    void mergeAlt(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;

        while( head1 != null && head2 != null) {
            curr.next = head1;
            head1 = head1.next;
            curr = curr.next;

            curr.next = head2;
            head2 = head2.next;
            curr = curr.next;
        }

        if (head1 != null) curr.next = head1;

    }

    ListNode reverse(ListNode head) {
        if(head.next == null) return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private int findLength(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
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
