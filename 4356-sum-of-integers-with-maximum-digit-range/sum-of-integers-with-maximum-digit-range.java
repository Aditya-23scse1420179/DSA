class Solution {
    public int maxDigitRange(int[] nums) {
        int maxi=0;
        int sum=0;
        if(nums.length==1)return nums[0];
        int[]arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int min=(int)1e9,max=-(int)1e9;
            String s=String.valueOf(nums[i]);
            for(char ch:s.toCharArray()){
                min=Math.min(min,ch-'0');
                max=Math.max(max,ch-'0');
            }
            int range=max-min;
            maxi=Math.max(maxi,range);
            arr[i]=range;
        }
        for(int i=0;i<nums.length;i++){
            if(arr[i]==maxi){
                sum+=nums[i];
            }
        }
        return sum;
    }
}