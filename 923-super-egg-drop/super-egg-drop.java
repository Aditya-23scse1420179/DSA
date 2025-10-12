class Solution {
    private int[][] memo;
    public int superEggDrop(int k, int n) {
        memo=new int[k+1][n+1];
        for (int i=0; i<=k;i++)
            for (int j =0; j<=n;j++)
                memo[i][j]=-1;
        return dp(k,n);
    }
    private int dp(int e, int f) {
        if (f ==0|| f==1) return f;
        if (e==1) return f;
        if (memo[e][f]!=-1) return memo[e][f];

        int low=1,high=f,ans =f;
        while (low<=high) {
            int mid = (low+high)/2;
            int broken= dp(e-1,mid-1); 
            int notBroken= dp(e, f-mid);  
            int worst=1 +Math.max(broken,notBroken);
            if (broken>notBroken) {
                high =mid-1; 
                ans =Math.min(ans,worst);
            } else {
                low =mid+1; 
                ans =Math.min(ans,worst);
            }
        }
        memo[e][f]=ans;
        return ans;
    }
}
