class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        int max=-(int)1e9,min=(int)1e9;
        for(int x:nums){
            max=Math.max(max,x);
            min=Math.min(min,x);
        }
        int[]freq=new int[max-min+1];
        for(int x:nums){
            freq[x-min]++;
        }int idx=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                nums[idx++]=i+min;
                freq[i]--;
            }
        }
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