class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int a:nums){
            low=Math.max(a,low);
            high+=a;
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;

    }public boolean helper(int[]nums,int k,int mid){
        int day=1,m=0;
        for(int a:nums){
            if(m+a>mid){
                day++;
                m=0;
            }
            m+=a;
            
        }
        return day<=k;

    }
}