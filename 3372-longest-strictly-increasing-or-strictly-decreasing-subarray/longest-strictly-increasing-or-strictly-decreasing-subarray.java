class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int mx=1;
        int inc=1,dsc=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                inc++;
                dsc=1;
            }else if(nums[i]<nums[i-1]){
                dsc++;
                inc=1;
            }else{
                inc=1;
                dsc=1;
            }
            mx=Math.max(mx,Math.max(inc,dsc));
        }
        return mx;

        
    }
}