class Solution {
    public int minOperations(int[] nums, int x) {
        int t=0;
        for(int a:nums)t+=a;
        if(x==t)return nums.length;
        int target=t-x;
        if(target<0)return -1;
        int l=0,cs=0,ans=-1;
        for(int r=0;r<nums.length;r++){
            cs+=nums[r];
            while(cs>target&&l<=r){
                cs-=nums[l];
                l++;
            }
            if(cs==target)ans=Math.max(ans,r-l+1);
        }
        return ans==-1?-1:nums.length-ans;
    }
}