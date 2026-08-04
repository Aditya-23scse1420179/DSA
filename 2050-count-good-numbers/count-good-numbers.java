class Solution {
    public int countGoodNumbers(long n) {
        long odd=n/2;
        long even=(n+1)/2;
        return (int)(helper(5,even)*helper(4,odd)%1000000007);
    }public long helper(long x,long n){
        if(n==0)return 1;
        long temp=helper(x,n/2);
        if(n%2==0)return (temp*temp)%1000000007;
        else return (x*temp*temp)%1000000007;
    }
}