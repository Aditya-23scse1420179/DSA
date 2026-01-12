class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[]newcut=new int[m+2];
        newcut[0]=0;
        newcut[newcut.length-1]=n;
        Arrays.sort(cuts);
        Integer[][]dp=new Integer[newcut.length][newcut.length];
        for(int i=0;i<cuts.length;i++){
            newcut[i+1]=cuts[i];
        }
        return helper(1,cuts.length,newcut,dp);
    }public int helper(int i ,int j,int[]newcut,Integer[][]dp){
        if(i>j)return 0;
        int min=(int)1e9;
        if(dp[i][j]!=null)return dp[i][j];
        for(int idx=i;idx<=j;idx++){
            int cost=newcut[j+1]-newcut[i-1]+helper(i,idx-1,newcut,dp)+helper(idx+1,j,newcut,dp);
            min=Math.min(min,cost);
        }
        return dp[i][j]=min;

    }
}