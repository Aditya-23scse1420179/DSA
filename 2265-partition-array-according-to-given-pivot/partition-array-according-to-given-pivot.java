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
        int []ans=new int[nums.length];
        int i=0;
        for(int x:less)ans[i++]=x;
        for(int x:equal)ans[i++]=x;
        for(int x:more)ans[i++]=x;
        return ans;
    }
}