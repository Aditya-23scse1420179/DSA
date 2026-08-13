class Solution {
    public int majorityElement(int[] nums) {
        int cand=0,count=0;
        for(int a:nums){
            if(count==0){
                cand=a;
            }
            if(cand==a){
                count++;
            }else {
                count--;
            }
        }
        return cand;
    }
}