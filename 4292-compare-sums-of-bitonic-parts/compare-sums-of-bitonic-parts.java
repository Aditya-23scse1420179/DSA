class Solution {
    public int compareBitonicSums(int[] nums) {
        int max=0;
        int id=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=Math.max(max,nums[i]);
                id=i;
            }
        }
        long asc=0,dsc=0;
        for(int i=0;i<=id;i++){
            asc+=nums[i];
        }
        for(int i=id;i<nums.length;i++){
            dsc+=nums[i];
        }
        if(asc>dsc)return 0;
        else if (dsc>asc)return 1;
        else return -1;
    }
}