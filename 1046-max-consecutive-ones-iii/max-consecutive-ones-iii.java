class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0,l=0,z=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)z++;
            while(z>k){
                if(nums[l]==0)z--;
                l++;
            }
            max=Math.max(max,i-l+1);
        }
        return max;
    }
}