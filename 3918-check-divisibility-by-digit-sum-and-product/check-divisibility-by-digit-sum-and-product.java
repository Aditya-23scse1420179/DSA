class Solution {
    public boolean checkDivisibility(int n) {
        int s=0,m=1,o=n;
        while(n>0){
            s+=n%10;
            m*=n%10;
            n/=10;
        }
        return o%(m+s)==0;
    }
}