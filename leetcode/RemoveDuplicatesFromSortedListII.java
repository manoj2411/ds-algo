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
        if (head == null || head.next == null)
        	return head;

        ListNode dummy = new ListNode();
        ListNode last = dummy;
        ListNode curr = head;

        while(curr != null) {
            if (!isDuplicate(curr)) {
                last.next = curr;
                curr = curr.next;
                last = last.next;
                last.next = null;
            } else {
                curr = findNext(curr);
            }
        }

        return dummy.next;
    }

    private boolean isDuplicate(ListNode node) {
        return node.next != null && node.next.val == node.val;
    }

    private ListNode findNext(ListNode node) {
        ListNode curr = node.next;

        while(curr != null && curr.val == node.val) {
            curr = curr.next;
        }

        return curr;
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
