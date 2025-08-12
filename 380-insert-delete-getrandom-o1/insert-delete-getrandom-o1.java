class RandomizedSet {
    ArrayList<Integer> arr;
    HashMap<Integer,Integer> hash;

    public RandomizedSet() {
        arr = new ArrayList<>();
        hash = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(hash.containsKey(val))return false;

        int ind = arr.size();
        arr.add(val);
        hash.put(val,ind);

        return true;
    }
    
    public boolean remove(int val) {
        if (!hash.containsKey(val)) return false;

        int ind = hash.get(val);
        int lastVal = arr.get(arr.size() - 1);

        arr.set(ind, lastVal);
        hash.put(lastVal, ind);

        arr.remove(arr.size() - 1);
        hash.remove(val);

        return true;
    }
    
    public int getRandom() {
        int ind = (int)Math.floor((double)Math.random() * (double)arr.size());
        return arr.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */