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

	/*
		One pass solution:

		Idea is to keep 2 pointers left and right.
		 First move k positions and tag the curr node as left.
		 Then move curr until last node + another pointer (right) will move along
		 starting from head. When curr reach to end, right will be pointing to
		 the kth node from last.
	*/
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

class AlternateSolution {
	/*
		A 3 pass solution.
	*/
    public ListNode swapNodes(ListNode head, int k) {
        int length = findLength(head);

        ListNode node1 = getKthNode(head, k);
        ListNode node2 = getKthNode(head, (length - k) + 1);

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

        return head;
    }

    private ListNode getKthNode(ListNode head, int k) {
        ListNode curr = head;

        for(int i = 1; i < k; i++) {
            curr = curr.next;
        }

        return curr;
    }

    private int findLength(ListNode head) {
        int c = 0;
        while (head != null) {
            c++;
            head = head.next;
        }
        return c;
    }
}
