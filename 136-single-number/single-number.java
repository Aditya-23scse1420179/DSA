class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(int a:map.keySet()){
            if(map.get(a)==1)return a;
        }
        return -1;
    }
}