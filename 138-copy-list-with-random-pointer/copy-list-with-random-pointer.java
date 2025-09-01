/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)return null;

        HashMap<Node,Node> hash = new HashMap<>();

        Node temp = head;
        while(temp != null){
            hash.put(temp,new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node curr = hash.get(temp);
            if(temp.next != null)curr.next = hash.get(temp.next);
            if(temp.random != null)curr.random = hash.get(temp.random);

            temp = temp.next;
        }

        return hash.get(head);
    }
}