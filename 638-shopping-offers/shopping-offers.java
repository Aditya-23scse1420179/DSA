class Solution {
    List<Integer>price;
    List<List<Integer>>special;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price=price;
        this.special=special;
        return helper(0,needs);
    }public int helper(int idx,List<Integer>needs){
        int n=price.size();
        if(idx==special.size()){
            int cost=0;
            for(int i=0;i<n;i++){
                cost+=needs.get(i)*price.get(i);
            }
            return cost;
        }
        int take=helper(idx+1,needs);
        List<Integer>list=new ArrayList<>();
        boolean flag=true;
        List<Integer>ans=special.get(idx);
        for(int i=0;i<n;i++){
            if(needs.get(i)<ans.get(i)){
                flag=false;
                break;
            }list.add(needs.get(i)-ans.get(i));
        }
        if(flag){
            take=Math.min(take,ans.get(n)+helper(idx,list));
        }
        return take;
    }
}