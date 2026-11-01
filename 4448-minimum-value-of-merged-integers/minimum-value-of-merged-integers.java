class Solution {
    public int minMergedInteger(int[] nums) {
        int min=(int)1e9;
        for(int i=0;i<nums.length-1;i+=2){
            String s=String.valueOf(nums[i])+String.valueOf(nums[i+1]);
            int merge=Integer.parseInt(s);
            min=Math.min(min,merge);
        }
        return min;
    }
}