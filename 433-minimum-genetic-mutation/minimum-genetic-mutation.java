class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> st = new HashSet<>();

        for(String str : bank)st.add(str);

        char[] arr = {'A','C','G','T'};

        Queue<String[]> q = new LinkedList<>();

        q.offer(new String[]{start,"0"});

        while(!q.isEmpty()){
            String[] s = q.poll();
            String str = s[0];
            int num = Integer.parseInt(s[1]);

            if(str.equals(end))return num;

            for(int i=0;i<8;i++){
                for(char ch:arr){
                    String newStr = str.substring(0,i) + ch + str.substring(i+1,8);

                    if(st.contains(newStr)){
                        q.offer(new String[]{newStr,String.valueOf(num+1)});
                        st.remove(newStr);
                    }
                }
            }
        }

        return -1;
    }
}