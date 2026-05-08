class RandomizedSet {
    Set<Integer>set;
    Random rand;
    public RandomizedSet() {
        set=new HashSet<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(!set.contains(val)){
            set.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
            
        }
        return false;
        
    }
    
    public int getRandom() {
        // for(int a:set.values()){
            int ridx=rand.nextInt(set.size());
            Iterator<Integer>it=set.iterator();
            for(int i=0;i<ridx;i++){
                it.next();
            }
            return it.next();
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */