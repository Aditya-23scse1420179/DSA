class Solution {
    Long[][]dp;
    public long maxTotal(int[] nums, String s) {
        if(s.length()==1)return s.charAt(0)=='1'?nums[0]:0;
        dp=new Long[s.length()][2];
        long ans=0;
        if(s.charAt(0)=='1')ans=nums[0];
        ans=Math.max(ans+helper(1,1,nums,s),helper(1,0,nums,s));
        return ans;
    }public long helper(int idx,int taken,int[]nums,String s){
        int n=nums.length;
        if(idx>=n)return 0;
        if(dp[idx][taken]!=null)return dp[idx][taken];
        long ntake=helper(idx+1,0,nums,s);
        long take=0;
        if(s.charAt(idx)=='1'){
            take=nums[idx]+helper(idx+1,1,nums,s);
            if(taken==0){
                take=Math.max(take,nums[idx-1]+helper(idx+1,0,nums,s));
            }
        }
        return dp[idx][taken]=Math.max(take,ntake);
    }
}