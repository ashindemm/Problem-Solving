class RandomizedSet {
    List<Integer> set;
    Map<Integer, Integer> indexMap;
    Random rand = new Random();

    public RandomizedSet() {
        set = new ArrayList<Integer>();
        indexMap = new HashMap<Integer, Integer>();
    }
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val))
            return false;
        set.add(val);
        indexMap.put(val, set.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val))
            return false;
        
        int indexToDelete = indexMap.get(val);
        int lastVal = set.get(set.size() - 1);
        set.set(indexToDelete, lastVal);
        indexMap.put(lastVal, indexToDelete);
        
        set.remove(set.size() - 1);
        indexMap.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        return set.get(rand.nextInt(set.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */