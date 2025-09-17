class FoodRatings {
    HashMap<String,Integer> rated;
    HashMap<String,PriorityQueue<Pair>> currBest;
    HashMap<String,String> hash;

    class Pair{
        String str;
        int rating;
        Pair(String str,int rating){
            this.str = str;
            this.rating = rating;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        rated = new HashMap<>();
        hash = new HashMap<>();
        currBest = new HashMap<>(); 

        int n = foods.length;
        for(int i=0;i<n;i++){
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];

            rated.put(f,r);
            hash.put(f,c);
            if(!currBest.containsKey(c)){
                currBest.put(c,new PriorityQueue<>((a,b) -> {
                    if(a.rating != b.rating)return Integer.compare(b.rating,a.rating);
                    else return a.str.compareTo(b.str);
                }));
            }
            currBest.get(c).add(new Pair(f,r));
        }
    }
    
    public void changeRating(String food, int newRating) {
        rated.put(food,newRating);
        currBest.get(hash.get(food)).offer(new Pair(food,newRating));
    }
    
    public String highestRated(String c) {
        if(!currBest.containsKey(c)){
            return "";
        }   

        PriorityQueue<Pair> curr = currBest.get(c);
        while(rated.get(curr.peek().str) != curr.peek().rating){
            curr.poll();
        }

        return curr.peek().str;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */