/*
	https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
*/
class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next = new ListNode(3);

		System.out.println("Original list: ");
		printList(head);

		ListNode newHead = new Solution().deleteDuplicates(head);

		System.out.println("List with unique elements: ");
		printList(newHead);
	}

	static void printList(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("\n");
	}
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(head != null) {
            int val = head.val;

            if(head.next != null && head.next.val == val) {
                while(head != null && head.val == val)
                    head = head.next;
            } else {
                curr.next = head;
                head = head.next;
                curr = curr.next;
                curr.next = null;
            }
        }

        return dummy.next;
    }
}

/*
* 	Definition for singly-linked list.
*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}
