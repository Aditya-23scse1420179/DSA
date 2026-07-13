class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k)return -1;
        int max=-(int)1e9;
        for(int a:bloomDay){
            max=Math.max(max,a);
        }
        int low=0,high=max;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }public boolean helper(int[]bloomDay,int mid,int m,int k){
        int f=0,b=0;
        for(int i=0;i<bloomDay.length;i++){
            if(mid>=bloomDay[i]){
                f++;
                if(f==k){
                    b++;
                    f=0;
                }
            }else f=0;
            
        }
        return b>=m;
    }
}