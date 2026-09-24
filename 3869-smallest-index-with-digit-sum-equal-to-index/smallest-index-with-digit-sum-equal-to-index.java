class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<10){
                if(nums[i]==i)return i;
            }else{
                String s=String.valueOf(nums[i]);
                int sum=0;
                for(int x:s.toCharArray()){
                    sum+=x-'0';
                }
                if(sum==i)return i;
            }
        }
        return -1;
    }
}