class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0,count=0;
        for(int a:nums){
            if(a!=0){
                count+=a;
                ans=Math.max(ans,count);
            }else{
                count=0;
            }
        }
        return ans;
    }
}