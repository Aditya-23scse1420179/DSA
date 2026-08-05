class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int L, int S) {
        int n=nums.length;
        int[]pre=new int[n+1];
        pre[0]=nums[0];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        return Math.max(helper(pre,L,S),helper(pre,S,L));
    }public int helper(int[]pre,int L,int S){
        int b=0,ans=0;
        for(int i=L+S;i<pre.length;i++){
            int lw=pre[i-S]-pre[i-L-S];
            b=Math.max(b,lw);
            int curr=pre[i]-pre[i-S];
            ans=Math.max(ans,b+curr);
        }
        return ans;
    }
}