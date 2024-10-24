package Daily;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class deleteArrayFromLL {

    class ListNode{
        int val;
        ListNode next;

        ListNode (int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummyHead = new ListNode(-1,null);
        Set<Integer> st = new HashSet<>();
        for(int num : nums) st.add(num);

        ListNode prev = dummyHead;  // Start with the dummy head node
        ListNode current = head;    // Start with the actual head node

        while (current != null) {
            if (!st.contains(current.val)) {
                prev.next = current;
                prev = prev.next;
            }
            // Move to the next node in the list
            current = current.next;
        }
        prev.next = null;
        return dummyHead.next;
    }
}
