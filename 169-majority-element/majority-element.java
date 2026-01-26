class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int freq=0;
        int ans=0;
        for(int f:map.keySet()){
            if(map.get(f)>freq){
                freq=map.get(f);
                ans=f;
            }
        }
        return ans;
    }
}