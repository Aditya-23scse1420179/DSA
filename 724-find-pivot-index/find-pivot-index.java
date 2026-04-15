class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int l=0,r=0;
            for(int j=0;j<i;j++){
                l+=nums[j];
            }
            for(int k=i+1;k<n;k++){
                r+=nums[k];
            }
            if(l==r)return i;
        }
        return -1;
    }
}