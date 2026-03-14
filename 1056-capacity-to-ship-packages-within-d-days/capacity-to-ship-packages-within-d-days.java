class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0;
        for(int a:weights){
            low=Math.max(low,a);
            high+=a;
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(weights,days,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
        
    }public boolean helper(int[]weights,int days,int m){
        int day=1;
        int ship=0;
        for(int a:weights){
            if(ship+a>m){//load me value ko add karo agar mid(capacity)se upar nikal jaye dusre din loading karna day++ aur ship ko empty karo ; other wise load me add kare raho 
                day++;
                ship=0;
            }
            ship+=a;
        }
        return day<=days;
    }
}