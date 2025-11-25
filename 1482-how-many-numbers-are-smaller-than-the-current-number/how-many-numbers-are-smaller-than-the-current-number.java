class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int []sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer>rank=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!rank.containsKey(sorted[i])){
                rank.put(sorted[i],i);
            }
        }
        int[]num= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            num[i]=rank.get(nums[i]);
        }
        return num;
    }
}