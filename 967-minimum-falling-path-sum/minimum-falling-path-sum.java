class Solution {
    int n;
    int m;
    Integer[][]dp;
    public int minFallingPathSum(int[][] mat) {
        n=mat.length;
        m=mat[0].length;
        dp=new Integer[n+1][m+1];
        int ans=(int)1e9;
        for(int j=0;j<m;j++){
            ans=Math.min(ans,helper(mat,0,j));
        }
        return ans; 
    }public int helper(int [][]mat,int i,int j){
        
        if(j>=m||j<0)return (int)1e9;//boundary
        if(i==n-1)return mat[i][j];//dest
        if(dp[i][j]!=null)return dp[i][j]; 
        int down=helper(mat,i+1,j);
        int diaR=helper(mat,i+1,j-1);
        int diaL=helper(mat,i+1,j+1);
        return dp[i][j]=Math.min(down,Math.min(diaR,diaL))+mat[i][j];

    }
}