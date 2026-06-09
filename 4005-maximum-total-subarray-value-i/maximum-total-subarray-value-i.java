class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mx=-(int)1e9;
        int min=(int)1e9;
        for(int a:nums){
            if(a>mx)mx=a;
            if(a<min)min=a;
        }
        return (long)(mx-min)*k;
    }
}