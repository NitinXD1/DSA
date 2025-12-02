class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        
        long ans = 0;
        long sum = 0;
        int mod = (int)(1e9+7);

        for(int[] i:points){
            hash.put(i[1],hash.getOrDefault(i[1],0)+1);
        }

        for(int i:hash.values()){
            long edge = ((long)i * (i-1))/2;
            ans = (ans + edge * sum) % mod;
            sum = (sum + edge) % mod;
        }

        return (int) ans;
    }
}