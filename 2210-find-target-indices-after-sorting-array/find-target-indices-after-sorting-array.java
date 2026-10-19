class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer>list=new ArrayList<>();
        sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)list.add(i);
        }
        return list;
    }public void sort(int[]arr){
        int max=0,min=(int)1e9;
        for(int a:arr){
            max=Math.max(max,a);
            min=Math.min(min,a);
        }
        int[]freq=new int[max-min+1];
        for(int a:arr){
            freq[a-min]++;
        }
        int id=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]-->0){
                arr[id++]=i+min;
            }
        }
    }
}