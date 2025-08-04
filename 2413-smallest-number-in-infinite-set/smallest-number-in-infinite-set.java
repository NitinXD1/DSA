class SmallestInfiniteSet {
    private PriorityQueue<Integer> pq;
    private HashSet<Integer> inHeap;
    private int next;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        inHeap = new HashSet<>();
        next = 1;
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int val = pq.poll();
            inHeap.remove(val);
            return val;
        }
        return next++;
    }

    public void addBack(int num) {
        if (num < next && !inHeap.contains(num)) {
            pq.offer(num);
            inHeap.add(num);
        }
    }
}
