class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n=prices.length,m=discounts.length;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        List<Integer>p=new ArrayList<>();
        for(int a:prices)p.add(a);
        List<Integer>d=new ArrayList<>();
        for(int a:discounts)d.add(a);
        Collections.reverse(p);
        Collections.reverse(d);
        double ans=0.0;
        for(int i=0;i<p.size();i++){
            if(i<d.size()){
                ans+=p.get(i)*(100-d.get(i))/100.0;
            }else{
                ans+=p.get(i);
            }
        }
        return ans;
    }
}