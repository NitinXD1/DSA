class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        HashSet<String> st = new HashSet<>();

        for(String word : wordList)st.add(word);
        if(!st.contains(end))return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        int cnt = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int k=0;k<size;k++){
                String str = q.poll();

                if(str.equals(end))return cnt;

                int n = str.length();
                char[] arr = str.toCharArray();

                for(int i=0;i<n;i++){
                    char original = arr[i];
                    for(char ch='a';ch<='z';ch++){
                        arr[i] = ch;

                        String newStr = new String(arr);

                        if(st.contains(newStr)){
                            q.offer(newStr);
                            st.remove(newStr);
                        }
                    }
                    arr[i] = original;
                } 

            }
            
            cnt++;
        }

        return 0;
    }
}