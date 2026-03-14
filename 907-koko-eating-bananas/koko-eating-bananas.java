class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=-(int)1e9;
        for(int a:piles){
            n=Math.max(a,n);
        }
        int low=1;
        int high=n;
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(piles,mid,h)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }public boolean helper(int[]piles,int k,int h){
        long hours=0;
        for(int a:piles){
            hours+=a/k;
            if(a%k!=0)hours++;
        }
        return hours<=h;
    }
}