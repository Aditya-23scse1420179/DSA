class Solution {
    public int[] countOppositeParity(int[] nums) {
        int[]arr=new int[nums.length];
        int even=0,odd=0;
        for(int a:nums){
            if(a%2==0)even++;
            else odd++;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                even--;
                arr[i]=odd;
            }
            else {
                odd--;
                arr[i]=even;
            }
        }
        return arr;
    }
}