class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0,max=0;
        for(int a:nums){
            if(a==1){
                c++;
                max=Math.max(max,c);
            }
            if(a==0)c=0;
        }
        return max;
    }
}