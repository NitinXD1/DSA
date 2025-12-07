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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;

        ListNode left = head;
        ListNode mid = findMid(head);
        ListNode right = mid.next;

        mid.next = null;

        ListNode sortedLeft = sortList(left);
        ListNode sortedRight = sortList(right);

        return merge(sortedLeft,sortedRight);
    }

    public ListNode merge(ListNode left,ListNode right){
        ListNode tempHead = new ListNode(0);
        ListNode temp = tempHead;

        while(left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                left = left.next;
            }
            else{
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        while(left != null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while(right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return tempHead.next;
    }

    public ListNode findMid(ListNode root){
        ListNode slow = root;
        ListNode fast = root.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}