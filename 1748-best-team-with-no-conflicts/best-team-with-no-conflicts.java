class Solution {
    int[][]arr;
    Integer[][]dp;
    public int bestTeamScore(int[] scores, int[] ages) {
        arr=new int[scores.length][2];
        for(int i=0;i<scores.length;i++){
            arr[i][0]=scores[i];
            arr[i][1]=ages[i];
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return a[0]-b[0];
        });
        dp=new Integer[arr.length][arr.length+1];
        return helper(0,-1);
    }public int helper(int idx,int prev){
        if(idx==arr.length)return 0;
        if(dp[idx][prev+1]!=null)return dp[idx][prev+1];
        int ntake=helper(idx+1,prev);
        int take=0;
        if(prev==-1||arr[idx][1]>=arr[prev][1]){
            take=arr[idx][0]+helper(idx+1,idx);
        }
        return dp[idx][prev+1]=Math.max(ntake,take);
    }
}