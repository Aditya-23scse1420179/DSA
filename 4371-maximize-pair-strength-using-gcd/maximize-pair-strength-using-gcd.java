class Solution {
    public long maxPairStrength(int[] nums) {
        long max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i!=j){
                    long sum=((long)nums[i]*nums[j])/(helper(nums[i],nums[j])*helper(nums[i],nums[j]));
                    max=Math.max(max,sum);
                }
            }
        }
        return max;
    }public long helper(long a,long b){
        if(b==0)return a;
        return helper(b,a%b);
    }
}