class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> st = new HashSet<>();

        for(String str : bank)st.add(str);

        char[] arr = {'A','C','G','T'};

        Queue<String> q = new LinkedList<>();

        q.offer(start);
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int k=0;k<size;k++){
                String str = q.poll();

                if(str.equals(end))return steps;

                for(int i=0;i<8;i++){
                    for(char ch:arr){
                        String newStr = str.substring(0,i) + ch + str.substring(i+1,8);

                        if(st.contains(newStr)){
                            q.offer(newStr);
                            st.remove(newStr);
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}