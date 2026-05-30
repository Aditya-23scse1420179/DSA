class Solution {
    List<Integer> p;
    List<List<Integer>> s;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.p=price;
        this.s=special;
        return helper(0,needs);
    }public int helper(int idx,List<Integer>needs){
        int n=p.size();
        if(idx==s.size()){
            int cost=0;
            for(int i=0;i<n;i++){
                cost+=needs.get(i)*p.get(i);
            }
            return cost;
        }
        int take=helper(idx+1,needs);
        List<Integer>ans=s.get(idx);
        boolean valid=true;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.get(i)>needs.get(i)){
                valid=false;
                break;
            }
            list.add(needs.get(i)-ans.get(i));
        }
        if(valid){
            take=Math.min(take,ans.get(n)+helper(idx,list));
        }
        return take;


    }
}