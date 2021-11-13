import java.util.*;

/*
	https://leetcode.com/problems/remove-linked-list-elements/
*/
class RemoveLinkedListElements {
	public static void main(String[] args) {
		var head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(2);

		System.out.println("Original list:" + toList(head));
		head = new Solution().removeElements(head, 2);
		System.out.println("New list - 2 :" + toList(head));
	}

	static List<Integer> toList(ListNode node) {
		List<Integer> list = new ArrayList<>();
		while(node != null) {
			list.add(node.val);
			node = node.next;
		}
		return list;
	}
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;


        while(curr != null) {

            if (curr.val == val) {
                curr = curr.next;
            } else {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        prev.next = curr;
        return dummy.next;

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
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

