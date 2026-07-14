class Solution {
    public int splitArray(int[] nums, int k) {
        int low=-(int)1e9;
        int high=0;
        for(int i:nums){
            low=Math.max(i,low);
            high+=i;
        }int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(mid,k,nums)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }public boolean helper(int mid,int k,int[]nums){
        int d=1,m=0;
        for(int a:nums){
            m+=a;
            if(m>mid){
                d++;
                m=a;
            }
            
        }
        return d<=k;
    }
}