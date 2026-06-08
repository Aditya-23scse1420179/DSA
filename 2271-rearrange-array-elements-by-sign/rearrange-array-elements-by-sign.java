class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer>neg=new ArrayList<>();
        List<Integer>pov=new ArrayList<>();
        for(int a:nums){
            if(a<0)neg.add(a);
            else{
                pov.add(a);
            }
        }
        int i=0,j=0;
        for(int x=0;x<nums.length;x++){
            if(x%2==0)nums[x]=pov.get(i++);
            else nums[x]=neg.get(j++);
        }
        return nums;
    }
}