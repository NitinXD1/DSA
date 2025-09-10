class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> badUsers = new HashSet<>();

        HashMap<Integer,Set<Integer>> hash = new HashMap<>();

        for(int i=1;i<=languages.length;i++){
            hash.put(i,new HashSet<>());
        }

        for (int i = 0; i < languages.length; i++) {
            Set<Integer> set = Arrays.stream(languages[i]).boxed().collect(Collectors.toSet());
            hash.put(i + 1, set);
        }

        for(int[] i : friendships){
            int first = i[0];
            int second = i[1];
            boolean flag = true;

            for(int k : hash.get(first)){

                if(hash.get(second).contains(k)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                badUsers.add(i[0]);
                badUsers.add(i[1]);
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=1;i<=n;i++){
            int count = badUsers.size() - helper(hash,i,badUsers);
            min = Math.min(min,count);
        }

        return min;
    }

    public int helper(HashMap<Integer,Set<Integer>> hash,int lang,Set<Integer> badUsers){
        int cnt = 0;

        for(int i : badUsers){
            if(hash.get(i).contains(lang)){
                cnt++;
            }
        }

        return cnt;
    }
}