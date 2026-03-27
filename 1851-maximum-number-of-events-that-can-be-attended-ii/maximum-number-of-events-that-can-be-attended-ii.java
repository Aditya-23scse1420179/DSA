class Solution {
    int[]st;
    int[]et;
    int []p;
    Integer[][]dp;
    public int maxValue(int[][] e, int k) {
        int n=e.length;
        dp=new Integer[n][k+1];
        st=new int[n];
        et=new int[n];
        p=new int[n];
        Arrays.sort(e,(a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            st[i]=e[i][0];
            et[i]=e[i][1];
            p[i]=e[i][2];
        }
        return helper(0,k);
    }public int helper(int idx,int k){
        if(idx==st.length||k==0)return 0;
        if(dp[idx][k]!=null)return dp[idx][k];
        int ntake=helper(idx+1,k);
        int nidx=bs(idx,et[idx]);
        int take=helper(nidx,k-1)+p[idx];
        return dp[idx][k]=Math.max(ntake,take);
    }public int bs(int idx,int ett){
        int l=idx+1,r=st.length-1;
        int ans=st.length;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(st[mid]>=ett+1){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}