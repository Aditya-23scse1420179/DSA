class Solution {
    public int maximumTop(int[] nums, int k) {
        if(k==0)return nums[0];
        if(nums.length==1){
            return(k%2!=0)?-1:nums[0];
        }
        int max=-1;
        for(int i=0;i<Math.min(nums.length,k-1);i++){
            max=Math.max(max,nums[i]);//k-1 pop karke max lo 
        }
        if(k<nums.length)max=Math.max(max,nums[k]);//kth elemenet top pe hi rahne do kya pata vahi max ho.
        return max;
    }
}