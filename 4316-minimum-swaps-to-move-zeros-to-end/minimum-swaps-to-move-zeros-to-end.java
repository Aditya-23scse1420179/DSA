class Solution {
    public int minimumSwaps(int[] nums) {
        int n=nums.length;
        int l=0,r=nums.length-1;
        int opp=0;
        while(l<r){
            while(l<n&&nums[l]!=0)l++;
            while(r>=0&&nums[r]==0)r--;
            if(l<r){
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                opp++;
                l++;
                r--;
            }
        }
        return opp;
    }
}