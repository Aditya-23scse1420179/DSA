class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        List<Integer>eve=new ArrayList<>();
        List<Integer>odd=new ArrayList<>();
        for(int a:nums){
            if(a%2==0)eve.add(a);
            else odd.add(a);
        }
        int i=0,j=0;
        for(int x=0;x<nums.length;x++){
            if(x%2==0)nums[x]=eve.get(i++);
            else nums[x]=odd.get(j++);
        }
        return nums;
    }
}