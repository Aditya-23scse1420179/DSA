class Solution {
    public int[] pivotArray(int[] nums, int p) {
        List<Integer>less=new ArrayList<>();
        List<Integer>equal=new ArrayList<>();
        List<Integer>more=new ArrayList<>();
        for(int a:nums){
            if(a<p){
                less.add(a);
            }else if(a==p){
                equal.add(a);
            }else{
                more.add(a);
            }
        }
        int i=0;
        for(int x:less)nums[i++]=x;
        for(int x:equal)nums[i++]=x;
        for(int x:more)nums[i++]=x;
        return nums;
    }
}