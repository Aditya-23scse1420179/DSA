class Solution {
    public int maxProduct(int[] nums) {
        int prod=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i!=j){
                    int mult=(nums[i]-1)*(nums[j]-1);
                    prod=Math.max(prod,mult);
                }
                
            }
        }
        return prod;
    }
}