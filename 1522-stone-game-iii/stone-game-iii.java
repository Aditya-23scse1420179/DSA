class Solution {
    public String stoneGameIII(int[] s) {
        int[]dp=new int[s.length+1];
        Arrays.fill(dp,-(int)1e9);
        dp[s.length]=0;
        for(int i=s.length-1;i>=0;i--){
            int take=0;
            for(int k=0;k<3&&i+k<s.length;k++){
                take+=s[i+k];
                dp[i]=Math.max(dp[i],take-dp[i+k+1]);
            }
        }
        if(dp[0]>0)return "Alice";
        else if(dp[0]<0)return "Bob";
        else return "Tie";
    }
}