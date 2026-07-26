class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        if(nums.length<3)return -1;
        sort(nums);
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
    }public void sort(int[]nums){
        int min=(int)1e9,max=0;
        for(int a:nums){
            min=Math.min(min,a);
            max=Math.max(max,a);
        }
        int[]freq=new int[max-min+1];
        for(int a:nums){
            freq[a-min]++;
        }
        int idx=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                nums[idx++]=i+min;
                freq[i]--;
            }
        }
    }
}