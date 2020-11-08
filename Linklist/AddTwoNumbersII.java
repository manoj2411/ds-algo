import java.util.*;

/*
    https://leetcode.com/problems/add-two-numbers-ii/
*/

class AddTwoNumbersII {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        printList("l1", l1);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printList("l2", l2);

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);
        printList("result", result);
    }

    static void printList(String name, ListNode head) {
        System.out.print(name + ": ");
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int len1 = length(l1);
        int len2 = length(l2);

        return len1 > len2 ? add(l1, len1, l2, len2) : add(l2, len2, l1, len1);
    }


    private ListNode add(ListNode blist, int blen, ListNode slist, int slen) {

        Stack<int[]> stack = new Stack<>();

        while(blen != slen) {
            int[] pair = {blist.val, 0};
            stack.add(pair);
            blist = blist.next;
            blen--;
        }

        while(blist != null) {
            int[] pair = {blist.val, slist.val};
            stack.add(pair);
            blist = blist.next;
            slist = slist.next;
        }

        ListNode head = null;
        int carry = 0;
        while(stack.size() > 0) {
            int[] pair = stack.pop();
            int sum = pair[0] + pair[1] + carry;

            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }

        if( carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }

        return head;
    }

    private int length(ListNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
