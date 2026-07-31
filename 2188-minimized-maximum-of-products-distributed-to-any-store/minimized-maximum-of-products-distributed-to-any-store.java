class Solution {
    public int minimizedMaximum(int n, int[] q) {
        int low=0,high=0;
        for(int a:q){
            high=Math.max(high,a);
        }
        int ans=0;
        while(low<=high){
            int mid=low+high>>1;
            if(helper(mid,n,q)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }public boolean helper(int mid,int n,int[]q){
        int store=0;
        for(int a:q){
            store+=Math.ceil((double)a/mid);
        }
        return store<=n;
    }
}