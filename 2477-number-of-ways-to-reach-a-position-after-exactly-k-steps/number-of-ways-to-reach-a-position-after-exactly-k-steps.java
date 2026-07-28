class Solution {
    HashMap<String,Integer>dp=new HashMap<>();
    public int numberOfWays(int s, int e, int k) {
        return helper(s,e,k);
    }public int helper(int s,int r,int step){
        if(step==0){
            return s==r?1:0;
        }
        String key=s+","+step;
        if(dp.containsKey(key))return dp.get(key);
        long take=helper(s+1,r,step-1);
        long ntake=helper(s-1,r,step-1);
        dp.put(key,(int)((take+ntake)%1000000007));
        return (int)((take+ntake)%1000000007);
    }
}