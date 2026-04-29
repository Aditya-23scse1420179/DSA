class Solution {
    Integer[]dp;
    static int MOD= 1000000007;;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans=0;
        dp=new Integer[high+1];
        for(int i=low;i<=high;i++){
            ans=(ans+helper(i,zero,one))%MOD;
        }
        return ans;
    }public int helper(int i,int zero,int one){
        if(i==0)return 1;
        if(i<0)return 0;
        if(dp[i]!=null)return dp[i];
        int fz=helper(i-zero,zero,one);
        int fo=helper(i-one,zero,one);
        return dp[i]=(fz+fo)%MOD;
    }
}