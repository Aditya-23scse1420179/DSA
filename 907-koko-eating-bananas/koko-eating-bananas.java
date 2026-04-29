class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=-(int)1e9;
        for(int a:piles){
            n=Math.max(n,a);
        }
        int l=1;
        int high=n;
        int ans=h;
        while(l<=high){
            int mid=l+(high-l)/2;
            if(helper(piles,mid,h)){
                ans=mid;
                high=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }public boolean helper(int[]piles,int mid,int h){
        long hrs=0;
        for(int a:piles){
            hrs+=Math.ceil(a/mid);
            if(a%mid!=0)hrs++;
        }
        return hrs<=h;
    }
}