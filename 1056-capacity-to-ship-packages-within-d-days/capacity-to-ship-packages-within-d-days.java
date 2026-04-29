class Solution {
    public int shipWithinDays(int[] w, int d) {
        int low=0;
        int high=0;
        for(int a:w){
            high+=a;
            low=Math.max(low,a);
        }int ans=0;
        while(low<=high){
            int mid=(low+high)>>1;
            if(helper(w,d,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
        
    }public boolean helper(int[]w,int d,int mid){
        int ship=0;
        int days=1;
        for(int a:w){
            if(ship+a>mid){
                days++;
                ship=0;
            }
            ship+=a;
        }
        return days<=d;
    }
}