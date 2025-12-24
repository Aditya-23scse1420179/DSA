class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int dp[]=new int[nums.length];
        int parent[]= new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        int max=-1;
        for(int curr =1;curr<nums.length;curr++){
            for(int prev=0;prev<curr;prev++){
                if(nums[curr]%nums[prev]==0){
                    if(dp[prev]+1>dp[curr]){
                        dp[curr]=dp[prev]+1;
                        parent[curr]=prev;
                        max=Math.max(max,dp[curr]);
                    }
                }
            }
            
        }
        int lastIdx=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]==max){
                lastIdx=i;
                break;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=lastIdx;i!=-1;i=parent[i]){
            list.add(nums[i]);
        }
        Collections.reverse(list);
        return list;
    }
}