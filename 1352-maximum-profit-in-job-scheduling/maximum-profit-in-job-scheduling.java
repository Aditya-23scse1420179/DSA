class Solution {
    Integer[]dp;
    public int jobScheduling(int[] st, int[] et, int[] p) {
        int n=st.length;
        dp=new Integer[n];
        int[][]job=new int[n][3];
        for(int i=0;i<n;i++){
            job[i][0]=st[i];
            job[i][1]=et[i];
            job[i][2]=p[i];
        }
        Arrays.sort(job,(a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            st[i]=job[i][0];
            et[i]=job[i][1];
            p[i]=job[i][2];
        }
        return helper(st,et,p,0);

    }public int helper(int[]st,int[]et,int[]p,int idx){
        if(idx==st.length)return 0;
        if(dp[idx]!=null)return dp[idx];
        int ntake=helper(st,et,p,idx+1);
        int nidx=Bs(st,idx,et[idx]);
        int take=p[idx]+helper(st,et,p,nidx);
        return dp[idx]= Math.max(ntake,take);
    }public int Bs(int[] st, int idx, int endTime){
    int l = idx+1, r = st.length - 1;
    int ans = st.length; // agar koi job na mile to end return
    while(l <= r){
        int mid = (l + r) / 2;
        if(st[mid] >= endTime){
            ans = mid;   // candidate mila
            r = mid - 1; // aur pehle dekh lo
        }else{
            l = mid + 1;
        }
    }
    return ans;
}

}