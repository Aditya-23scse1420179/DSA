class Solution {
    public int maxProfit(int[] prices) {
        int MaxSum =0;
        int MinPrices = prices[0];
        for(int i =1;i<prices.length;i++){
            if(prices[i]<MinPrices){
                MinPrices=prices[i];
            }else{
                MaxSum=Math.max(prices[i]-MinPrices,MaxSum);
            }
        }
        return MaxSum;
        
    }
}