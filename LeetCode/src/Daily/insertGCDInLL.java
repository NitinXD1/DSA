package Daily;

public class insertGCDInLL {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        while(second != null){
            ListNode temp = new ListNode(gcd(first.val,second.val),second);
            first.next = temp;
            first = second;
            second = first.next;
        }
        return head;
    }
    //euclidian formula to find gcd
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
