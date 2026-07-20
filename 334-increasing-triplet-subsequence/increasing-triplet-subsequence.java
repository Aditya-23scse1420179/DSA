class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null||nums.length<3)return false;
        int min=Integer.MAX_VALUE;
        int max=Integer.MAX_VALUE;
        for(int a:nums){
            if(a<=min){
                min=a;
            }else if(a<=max){
                max=a;
            }else return true;
        }
        return false;
    }
}