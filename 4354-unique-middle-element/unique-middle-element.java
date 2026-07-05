class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int n=nums.length;
        int mid=nums[n/2];
        int freq=map.get(mid);
        return freq==1;
        
    }
}