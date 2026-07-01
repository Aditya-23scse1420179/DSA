class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[]res=new int[nums.length];
        int[]suf=new int[nums.length];
        res[0]=1;
        suf[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            suf[i]=suf[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            res[i]*=suf[i];

        }
        return res;
    }
}