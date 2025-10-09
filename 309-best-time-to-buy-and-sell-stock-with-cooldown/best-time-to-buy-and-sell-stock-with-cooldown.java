class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;
        if (n <=1) return 0;
        int hold =-prices[0];
        int sell =0;
        int cooldown =0;
        for (int i=1;i<n;i++) {
            int prevSell=sell;
            sell = hold +prices[i];
            hold = Math.max(hold,cooldown -prices[i]);
            cooldown = Math.max(cooldown, prevSell);
        }
        return Math.max(sell,cooldown);
    }
}