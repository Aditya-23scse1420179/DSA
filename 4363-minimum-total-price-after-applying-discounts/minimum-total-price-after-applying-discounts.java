class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n=prices.length,m=discounts.length;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        Double ans=0.0;
        for(int i=0;i<prices.length;i++){
            if(i<discounts.length){
                ans+=(prices[n-i-1]*(100-discounts[m-i-1]))/100.0;

            }else{
                ans+=prices[n-i-1];
            }
        }
        return ans;

    }
}