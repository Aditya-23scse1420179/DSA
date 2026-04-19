class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n=nums.length;
        for(int i=0;i<n;i++){
            int score=0;
            int min=(int)1e9;
            int max=-(int)1e9;
            for(int j=0;j<=i;j++){
                max=Math.max(max,nums[j]);
            }for(int l=i;l<n;l++){
                min=Math.min(min,nums[l]);
            }
            score=Math.abs(min-max);
            if(score<=k)return i;
        }
        return -1;
    }
}