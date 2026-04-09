class Solution {
    Integer[][]dp;
    int [][]jump={
        {4,6},
        {6,8},
        {7,9},
        {4,8},
        {3,9,0},
        {},
        {1,7,0},
        {2,6},
        {1,3},
        {2,4},
    };
    int MOD=1000000007;
    public int knightDialer(int n) {
        int ans=0;
        dp=new Integer[n][10];
        for(int i=0;i<10;i++){
            ans=(ans+helper(n-1,i))%MOD;
        }
        return ans;
    }public int helper(int remain,int sq){
        if(remain==0)return 1;
        if(dp[remain][sq]!=null)return dp[remain][sq];
        int ans=0;
        for(int a:jump[sq]){
            ans=(ans+helper(remain-1,a))%MOD;
        }
        return dp[remain][sq]=ans;
    }
}