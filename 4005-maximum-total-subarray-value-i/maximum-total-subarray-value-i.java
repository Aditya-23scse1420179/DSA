class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long mx=0;
        long min=(int)1e9;
        for(int a:nums){
            if(a>mx)mx=a;
            if(a<min)min=a;
        }
        return (mx-min)*1L*k;
    }
}