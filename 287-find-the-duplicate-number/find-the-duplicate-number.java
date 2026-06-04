class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int freq=0;
        int ans=0;
        for(int a:map.keySet()){
            if(map.get(a)>freq){
                freq=map.get(a);
                ans=a;
            }
        }
        return ans;
    }
}