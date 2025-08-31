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

                char[] word = str.toCharArray();

                for(int i=0;i<8;i++){
                    char original = word[i]; 
                    
                    for(char ch:arr){
                        word[i] = ch;
                        String newStr = new String(word);

                        if(st.contains(newStr)){
                            q.offer(newStr);
                            st.remove(newStr);
                        }
                    }

                    word[i] = original;
                }
            }
            steps++;
        }

        return -1;
    }
}