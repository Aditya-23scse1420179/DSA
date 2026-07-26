class Solution {
    public long countBadPairs(int[] nums) {
        long count=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int d=nums[i]-i;
            int gc=map.getOrDefault(d,0);
            count+=(i-gc);
            map.put(d,gc+1);
        }
        return count;
    }
}