class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=(int)1e9;
        for(int x:piles){
            n=Math.max(x,n);
        }
        int low=1;
        int high =n;
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(piles,h,mid)){
                ans =mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans ;
    }
    public static boolean helper(int[]piles,int h,int k){
        long hours=0;
        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) hours++;
        }
        return hours <= h;
    }
}