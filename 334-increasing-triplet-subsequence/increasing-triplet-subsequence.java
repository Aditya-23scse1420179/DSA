class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null||nums.length<3)return false;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int idx=Collections.binarySearch(list,nums[i]);
            if(idx<0)idx=-(idx+1);
            if(idx==list.size()){
                list.add(nums[i]);
            }else{
                list.set(idx,nums[i]);
            }
        }
        return list.size()>=3;
    }
}