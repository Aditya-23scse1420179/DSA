class Solution {
    int[]nums;
    Integer[][][]dp;
    public int subsequencePairCount(int[] nums) {
        this.nums=nums;
        int max=-(int)1e9;
        for(int a:nums){
            max=Math.max(max,a);
        }
        dp=new Integer[201][max+1][max+1];
        return helper(0,0,0);
    }
    public int helper(int idx,int first,int second){
        if(idx==nums.length){
            if(first!=0&&first==second){
                return 1;
            }
            return 0;   
        }
        if(dp[idx][first][second]!=null)return dp[idx][first][second];
        long ntake=helper(idx+1,first,second);
        long take1=helper(idx+1,gcd(first,nums[idx]),second);
        long take2=helper(idx+1,first,gcd(second,nums[idx]));
        return dp[idx][first][second]=(int)((ntake+take1+take2)%1000000007);
    }
    public int gcd(int a ,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}