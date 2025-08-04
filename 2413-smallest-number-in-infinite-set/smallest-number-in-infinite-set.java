class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    int[] hash = new int[1001];
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();

        for(int i=1;i<=1000;i++){
            pq.offer(i);
        }

        Arrays.fill(hash,1);
    }
    
    public int popSmallest() {
        int val = pq.poll();
        hash[val]--;
        return val;
    }
    
    public void addBack(int num) {
        if(hash[num] == 1)return;
        pq.offer(num);
        hash[num] = 1;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */