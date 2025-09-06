class LRUCache {

    class Node{
        int val;
        int key;
        Node prev;
        Node next;

        Node(int val,int key){
            this.val = val;
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }

    int cap;
    HashMap<Integer,Node> hash;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        tail.prev = head;
        head.next = tail;

        hash = new HashMap<>();

        cap = capacity;
    }
    
    public int get(int key) {
        
        if(hash.containsKey(key)){
            Node node = hash.get(key);
            deleteNode(node);
            insertNode(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(hash.containsKey(key)){
            Node newNode = new Node(value,key);
            deleteNode(hash.get(key));
            hash.remove(key);
            hash.put(key,newNode);
            insertNode(newNode);
        }
        else{
            Node newNode = new Node(value,key);
            if(hash.size() == cap){
                hash.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            hash.put(key,newNode);
            insertNode(newNode);
        }
    }

    public void insertNode(Node node){
        Node currHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = currHead;
        currHead.prev = node;
    }

    public void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */