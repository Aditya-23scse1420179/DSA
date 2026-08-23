class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int max=(int)1e9;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i!=j&&nums[i]==1&&nums[j]==2||nums[i]==2&&nums[j]==1){
                    max=Math.min(max,j-i);
                }
            }
        }
        return max>=(int)1e9?-1:max;
    }
}