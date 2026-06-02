class Solution {
    public int[] sortArray(int[] nums) {
        int min=(int)1e9;
        int max=-(int)1e9;
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
        return nums;
    }
}