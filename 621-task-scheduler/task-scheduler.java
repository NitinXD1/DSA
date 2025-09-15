class Solution {
    
    class Pair{
        char ch;
        int freq;

        Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.freq,a.freq));

        int[] hash = new int[26];
        for(char ch:tasks)hash[ch - 'A']++;

        for(int i=0;i<26;i++){
            if(hash[i] != 0){
                pq.offer(new Pair((char)('A'+i),hash[i]));
            }
        }

        int cnt = 0;
        while(!pq.isEmpty()){
            int cycle = n+1;
            List<Pair> temp = new ArrayList<>();

            while(cycle > 0 && !pq.isEmpty()){
                Pair curr = pq.poll();

                curr.freq = curr.freq-1;

                if(curr.freq > 0)temp.add(curr);
                
                cycle--;
                cnt++;
            }

            for(Pair p:temp)pq.offer(p);

            if(pq.isEmpty())break;
            cnt += cycle;
        }

        return cnt;
    }

}