class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int ans=(int)1e9;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums.get(j);
                int len=j-i+1;
                if(len>=l&&len<=r&&sum>0)ans=Math.min(ans,sum);
            }
        }
        return ans==(int)1e9?-1:ans;
    }
}