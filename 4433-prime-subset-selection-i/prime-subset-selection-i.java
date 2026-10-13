class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer>list=new ArrayList<>();
        int sum=0;
        for(int i=2;i<=n;i++){
            if(helper(i)){
                if(sum+i<=s){
                    sum+=i;
                    list.add(i);
                }else{
                    break;
                }
            }
        }
        return list;
    }public boolean helper(int n){
        if(n<=1)return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}