class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Long[][][]dp=new Long[nums1.length][nums2.length][k+1];
        return helper(0,0,nums1,nums2,k,dp);
    }public long helper(int i,int j,int[]nums1,int []nums2,int k,Long[][][]dp){
        if(i==nums1.length||j==nums2.length){
            if(k==0)return 0;
            return Long.MIN_VALUE / 2;
        }long ans=Long.MIN_VALUE / 2;
        if(dp[i][j][k]!=null)return dp[i][j][k];
        ans=Math.max(ans,helper(i+1,j+1,nums1,nums2,k,dp));
        ans=Math.max(ans,helper(i+1,j,nums1,nums2,k,dp));
        ans=Math.max(ans,helper(i,j+1,nums1,nums2,k,dp));
        if(k>0){
            ans=Math.max(ans,(long)nums1[i]*nums2[j]+helper(i+1,j+1,nums1,nums2,k-1,dp));
        }
        return dp[i][j][k]= ans;
    }
}