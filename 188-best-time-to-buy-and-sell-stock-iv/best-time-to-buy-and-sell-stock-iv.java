class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(k==0||n==0)return 0;
        if(k>=n/2){
            int p=0;
            for(int i=1;i<n;i++){
                if(prices[i]>prices[i-1]){
                    p+=prices[i]-prices[i-1];
                }
            }
            return p;
        }
        int[]buy=new int[k+1];
        int[]sell=new int[k+1];
        for(int i=0;i<=k;i++){
            buy[i]=-(int)1e9;
            sell[i]=0;
        }

        for(int p:prices){
            for(int j=1;j<=k;j++){
                buy[j]=Math.max(buy[j],sell[j-1]-p);
                sell[j]=Math.max(sell[j],buy[j]+p);
            }
        }
        return sell[k];
    }
}