class Solution {
    public int findKthLargest(int[] nums, int k) {
        sort(nums);
        return nums[nums.length-k];
    }public void sort(int[]nums){
        int min=(int)1e9,max=-(int)1e9;
        for(int a:nums){
            min=Math.min(min,a);
            max=Math.max(max,a);
        }
        int[]freq=new int[max-min+1];
        for(int a:nums){
            freq[a-min]++;
        }int id=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                nums[id++]=i+min;
                freq[i]--;
            }
        }
    }
}