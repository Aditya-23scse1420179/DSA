class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n=t.size();
        Integer[]dp=new Integer[n];
        for(int j=0;j<n;j++){
            dp[j]=t.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=Math.min(dp[j],dp[j+1])+t.get(i).get(j);
            }
        }
        return dp[0];
    }
}
