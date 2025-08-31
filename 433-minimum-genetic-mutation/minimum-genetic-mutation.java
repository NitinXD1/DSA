class Solution {
    class Pair{
        String s;
        int val;

        Pair(String s,int val){
            this.s = s;
            this.val = val;
        }
    }

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> st = new HashSet<>();

        for(String str : bank)st.add(str);

        char[] arr = {'A','C','G','T'};

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(start,0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String str = p.s;
            int num = p.val;

            if(str.equals(end))return num;

            for(int i=0;i<8;i++){
                for(char ch:arr){
                    String newStr = str.substring(0,i) + ch + str.substring(i+1,8);

                    if(st.contains(newStr)){
                        q.offer(new Pair(newStr,num+1));
                        st.remove(newStr);
                    }
                }
            }
        }

        return -1;
    }
}