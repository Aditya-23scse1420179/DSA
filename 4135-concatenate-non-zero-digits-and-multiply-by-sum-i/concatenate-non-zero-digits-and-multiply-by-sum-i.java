class Solution {
    public long sumAndMultiply(int n) {
        long ans=0;
        long anss=0;
        long sum=0;
        while(n>0){
            ans=ans*10+n%10;
            n/=10;
        }
        while(ans>0){
            long digit=ans%10;
            if(digit!=0){
                anss=anss*10+digit;
                sum+=digit;
            }
            ans/=10;
        }
        return sum*anss;
    }
}