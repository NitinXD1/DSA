class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans = new ArrayList<>();

        for(int i:asteroids){
            if(i > 0){
                ans.add(i);
            }
            else{
                while(ans.size() > 0 && ans.get(ans.size()-1) > 0 && ans.get(ans.size()-1) < Math.abs(i)){
                    ans.remove(ans.size()-1);
                }

                if(ans.size() > 0 && ans.get(ans.size()-1) == Math.abs(i)){
                    ans.remove(ans.size()-1);
                }
                else if(ans.size() == 0 || ans.get(ans.size()-1) < 0){
                    ans.add(i);
                }
            }
        }

        return ans.stream().mapToInt(i->i).toArray();
    }
}