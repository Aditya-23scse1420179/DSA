class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max=-(int)1e9;
        int min=(int)1e9;
        for(int a:nums){
            if(a>max)max=Math.max(a,max);
            if(a<min)min=Math.min(a,min);
        }
        return (long)(max-min)*k;
    }
}