class Solution {
    public int longestSubsequence(int[] nums) {
        int x=0;
        boolean flag=false;
        for(int a:nums){
            x^=a;
            if(a!=0){
                flag=true;
            }
        }
        if(x!=0)return nums.length;
        return flag?nums.length-1:0;
    }
}