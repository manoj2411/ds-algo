/*
	https://leetcode.com/problems/palindrome-linked-list/
*/
class PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);

		System.out.println(new Solution().isPalindrome(head)); // true
	}
}

class Solution {
	/*
		complexity of solution:

			time: 	O(N)
			space: 	O(1)
	*/
    public boolean isPalindrome(ListNode head) {

        int len = findListLenght(head);

        if (len == 1) return true;

        ListNode curr = head;
        for(int i = 1; i < len / 2; i++)
            curr = curr.next;

        ListNode mid = curr.next;
        curr.next = null;

        if(len % 2 == 1)
            mid = mid.next;

        mid = reverseList(mid);

        ListNode currm = mid;
        curr = head;
        while(curr != null) {
            if (curr.val != currm.val) return false;
            curr = curr.next;
            currm = currm.next;
        }

        return true;
    }

    int findListLenght(ListNode head) {
        int len = 0;

        while(head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

/**
 * 	Definition for singly-linked list.
*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}
