class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n=nums.length;
        int count=0;
        for(int left=0;left<n;left++){
            int x=0,y=0;
            for(int i=left;i<n;i++){
                if(nums[i]%2==0)x++;
                else y++;
                if(y>0&&(long)b*x<=(long)y*a){
                    count++;
                }
            }
            // right++;
        }
        return count;
    }
}