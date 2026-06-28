class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long sum=0;
        int i=0;
        while(i<k){
            if(mul>1){
                sum+=1L*nums[nums.length-i-1]*mul;
                mul--;
            }else{
                sum+=nums[nums.length-i-1];
            }
            i++;
        }
        return sum;
    }
}