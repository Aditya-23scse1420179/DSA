class Solution {
    public int countConsistent(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            int min=(int)1e9,andv=nums[i];
            for(int j=i;j<nums.length;j++){
                min=Math.min(min,nums[j]);
                andv&=nums[j];
                if(andv==min)c++;
            }
        }
        return c;

    }
}