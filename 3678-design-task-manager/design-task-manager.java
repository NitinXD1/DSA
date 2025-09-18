class TaskManager {

    PriorityQueue<int[]> pq;
    HashMap<Integer,int[]> hash;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a,b) -> {
            if(a[2] != b[2])return Integer.compare(b[2],a[2]);
            else return Integer.compare(b[1],a[1]);
        });

        hash = new HashMap<>();

        for(List<Integer> ls : tasks){
            pq.offer(new int[]{ls.get(0),ls.get(1),ls.get(2)});
            hash.put(ls.get(1),new int[]{ls.get(0),ls.get(2)});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        pq.offer(new int[]{userId,taskId,priority});
        hash.put(taskId,new int[]{userId,priority});
    }
    
    public void edit(int taskId, int newPriority) {
        int userId = hash.get(taskId)[0];
        hash.put(taskId,new int[]{userId,newPriority});
        pq.offer(new int[]{userId,taskId,newPriority});
    }
    
    public void rmv(int taskId) {
        hash.remove(taskId);
    }
    
    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.peek();
            int taskId = top[1];
            if (!hash.containsKey(taskId)) {
                pq.poll();
                continue;
            }
            int[] cur = hash.get(taskId);
            if (cur[0] != top[0] || cur[1] != top[2]) {
                pq.poll();
                continue;
            }
            break;
        }

        if(pq.isEmpty())return -1;

        int[] curr = pq.poll();
        hash.remove(curr[1]);

        return curr[0];
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */