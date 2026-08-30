class Solution {
    public int countSpecialIntegers(int[] nums) {
        Set<Integer>ans=new HashSet<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i==0||nums[i]!=nums[i-1]){
                if(set.contains(nums[i]))ans.remove(nums[i]);
                else {
                    set.add(nums[i]);
                    ans.add(nums[i]);
                }
            }
        }
        return ans.size();
    }
}