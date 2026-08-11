class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int a:nums){
            set.add(a);
        }
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                max+=nums[i];
            }else{
                break;
            }
        }
        while(set.contains(max)){
            max++;
        }
        return max;
    }
}