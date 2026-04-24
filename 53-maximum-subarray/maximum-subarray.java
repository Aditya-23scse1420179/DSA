class Solution {
    public int maxSubArray(int[] nums) {
        int maxS=-(int)1e9;
        int currS=0;
        for(int a:nums){
            currS+=a;
            maxS=Math.max(currS,maxS);
            if(currS<0)currS=0;
        }
        return maxS;
    }
}