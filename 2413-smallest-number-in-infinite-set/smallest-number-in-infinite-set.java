class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> hash;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        hash = new HashSet<>();

        for(int i=1;i<=1000;i++){
            pq.offer(i);
            hash.add(i);
        }
    }
    
    public int popSmallest() {
        int val = pq.poll();
        hash.remove(val);
        return val;
    }
    
    public void addBack(int num) {
        if(hash.contains(num))return;
        pq.offer(num);
        hash.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */