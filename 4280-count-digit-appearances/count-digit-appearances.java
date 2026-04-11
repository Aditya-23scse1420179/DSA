class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            String s=String.valueOf(nums[i]);
            for(char ch:s.toCharArray()){
                if(ch-'0'==digit){
                    count++;
                }
            }
        }
        return count;
    }
}