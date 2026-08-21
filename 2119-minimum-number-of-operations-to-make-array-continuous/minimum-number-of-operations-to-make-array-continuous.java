class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int m=1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]){
                nums[m]=nums[i];
                m++;
            }
        }
        int res=n,j=0;
        for(int i=0;i<n;i++){
            int target=nums[i]+n-1;
            while(j<m&&nums[j]<=target){
                j++;
            }
            res=Math.min(res,n-(j-i));
        }
        return res;
    }
}