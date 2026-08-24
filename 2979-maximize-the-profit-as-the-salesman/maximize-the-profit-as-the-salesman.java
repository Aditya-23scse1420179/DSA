class Solution {
    Integer[]dp;
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers,(a,b)->a.get(0)-b.get(0));
        dp=new Integer[offers.size()];
        return helper(offers,0);
    }public int helper(List<List<Integer>>offers,int idx){
        if(idx>=offers.size())return 0;
        if(dp[idx]!=null)return dp[idx];
        int ntake=helper(offers,idx+1);
        int idxx=bs(offers,idx,offers.get(idx).get(1));
        int take=offers.get(idx).get(2)+helper(offers,idxx);
        return dp[idx]=Math.max(ntake,take);
    }public int bs(List<List<Integer>>offers,int idx,int et){
        int low=idx+1,high=offers.size()-1;
        int ans=offers.size();
        while(low<=high){
            int mid=low+(high-low)/2;
            if(offers.get(mid).get(0)>et){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}