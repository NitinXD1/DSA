class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode second = rev(slow);
        
        int max = 0;
        while (second != null) {
            max = Math.max(max, head.val + second.val);
            head = head.next;
            second = second.next;
        }

        return max;
    }

    public ListNode rev(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
