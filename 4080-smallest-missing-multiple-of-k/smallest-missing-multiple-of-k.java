class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer>set=new HashSet<>();
        for(int a:nums){
            set.add(a);
        }
        for(int i=1;i<500;i++){
            if(i%k==0&&!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}