class Solution {
    public List<Integer> findCoins(int[] nums) {
        List<Integer> coins = new ArrayList<>();
        for(int i = 1;i<=nums.length;i++){
            int[][] dp = new int[coins.size()+1][i+1];
            for(int x = 0;x<dp.length;x++){
                for(int j = 0;j<dp[x].length;j++){
                    dp[x][j] = -1;
                }
            }
            int ways = helper(0,i,coins,dp);
            if(ways+1 == nums[i-1]){
                coins.add(i);
            }
            else if(ways == nums[i-1]){
                continue;
            }
            else{
                return new ArrayList<>();
            }
        }
        return coins;
    }
    public int helper(int i, int amount, List<Integer> coins, int[][] dp){
        if(amount == 0) return 1;
        if(amount<0 || i>= coins.size()) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int notpick = helper(i+1,amount,coins,dp);
        int pick = 0;
        if(coins.get(i)<=amount){
            pick = helper(i,amount-coins.get(i),coins,dp);
        }
        return dp[i][amount] = pick + notpick;
    }
}