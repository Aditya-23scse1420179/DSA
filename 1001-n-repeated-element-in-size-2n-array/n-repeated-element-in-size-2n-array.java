class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int x:nums){
            if(map.containsKey(x))return x;
            map.put(x,1);
        }
        return -1;
    }
}