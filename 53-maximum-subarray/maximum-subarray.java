class Solution {
    public int maxSubArray(int[] nums) {
        int max=-(int)1e9;
        int num=0;
        for(int a:nums){
            num+=a;
            max=Math.max(max,num);
            if(num<0){
                num=0;
            }
        }
        return max;
    }
}