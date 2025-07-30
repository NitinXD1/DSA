/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead = slow.next; 
        slow.next = null;
        slow.next = rev(revHead);

        ListNode temp1 = head;
        ListNode temp2 = slow.next;

        int max = 0;

        while(temp2 != null){
            max = Math.max(max,temp1.val + temp2.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return max;
    }

    public ListNode rev(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}