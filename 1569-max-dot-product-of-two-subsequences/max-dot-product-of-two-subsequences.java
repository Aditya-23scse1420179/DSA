class Solution {
    Integer[][]dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp=new Integer[nums1.length][nums2.length];
        return helper(0,0,nums1,nums2);
    }public int helper(int a,int b,int[]nums1,int[]nums2){
        if(a>=nums1.length||b>=nums2.length)return -(int)1e9;
        if(dp[a][b]!=null)return dp[a][b];
        int ntake=helper(a,b+1,nums1,nums2);
        int ntake2=helper(a+1,b,nums1,nums2);
        int take=nums1[a]*nums2[b]+Math.max(0,helper(a+1,b+1,nums1,nums2));
        return dp[a][b]= Math.max(ntake,Math.max(ntake2,take));
    }
}