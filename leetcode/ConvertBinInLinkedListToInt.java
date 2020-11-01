class ConvertBinInLinkedListToInt {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);

        Solution sol = new Solution();

        // 10
        System.out.println(sol.getDecimalValue(head));
    }
}



class Solution {

    public int getDecimalValue(ListNode head) {
        int num = 0;
        ListNode curr = head;

        while(curr != null) {
            int bit = curr.val;
            num = (num << 1) | bit;
            curr = curr.next;
        }
        return num;
    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
