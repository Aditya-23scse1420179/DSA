class Solution {
    public int maxProfit(int[] prices) {
        int minp=(int)1e9;
        int profit=0;
        for(int x:prices){
            if(x<minp){
                minp=x;
            }else{
                profit=Math.max(profit,x-minp);
            }
        }
        return profit;
    }
}