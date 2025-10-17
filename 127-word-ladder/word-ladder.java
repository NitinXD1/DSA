class Solution {
    
    class Pair{
        String s;
        int steps;

        Pair(String s,int steps){
            this.s = s;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> st = new HashSet<>();

        for(String str : wordList)st.add(str);

        if(!st.contains(endWord) || beginWord == endWord)return 0;

        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String curr = p.s;
            int s = p.steps;

            char[] arr = curr.toCharArray();

            if(curr.equals(endWord))return s;

            for(int i=0;i<arr.length;i++){
                char currChar = arr[i];

                for(char ch='a';ch<='z';ch++){
                    if(ch != currChar){
                        arr[i] = ch;
                        String newStr = new String(arr);
                        if(st.contains(newStr))q.offer(new Pair(newStr,s+1)); 
                        st.remove(newStr);
                    }
                }

                arr[i] = currChar;
            } 
        }

        return 0;
    }
}