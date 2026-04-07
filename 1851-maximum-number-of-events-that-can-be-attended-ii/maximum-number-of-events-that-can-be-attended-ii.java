class Solution {//)(2^n*n)Tle use bsearch 2*nlogn
    int[]st;
    int[]et;
    int[]p;
    int n;
    Integer[][]dp;
    public int maxValue(int[][] events, int k) {
        n=events.length;
        dp=new Integer[n+1][k+1];
        st=new int[n];
        et=new int[n];
        p=new int[n];
        Arrays.sort(events,(a,b)->a[0]-b[0]);//to array events like timeline so when we skip idx+1 then we can direct access next 
        for(int i=0;i<n;i++){
            st[i]=events[i][0];
            et[i]=events[i][1];
            p[i]=events[i][2];
        }
        return helper(0,k);
    }public int helper(int idx,int k){
        if(idx==n||k==0)return 0;
        if(dp[idx][k]!=null)return dp[idx][k];
        int ntake=helper(idx+1,k);
        int next = bsearch(idx,et[idx]);
        // while(next<n&&st[next]<=et[idx]){
        //     next++;
        // }
        int take=helper(next,k-1)+p[idx];
        
        return dp[idx][k]=Math.max(take,ntake);
    }public int bsearch(int idx,int et){
        int l=idx+1;
        int h=n-1;
        int ans=st.length;
        while(l<=h){
            int mid=l+h>>1;
            if(st[mid]>=et+1){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}