class Solution {
    public int minSteps(int n) {
        if(n==1)return 0;
        if(isprime(n))return n;
        return helper(n);
    }public static int helper(int n) {
        int sum= 0;
        while(n%2==0){
            sum+=2;
            n/=2;
        }

        for(int i= 3;i*i<=n;i+=2){
            while(n%i==0) {
                sum+=i;
                n/=i;
            }
        }
        
        if (n>2){
            sum+=n;
        }
        
        return sum;
    }public boolean isprime(int n){
        if(n<2)return false;
        if(n==2)return true;
        if(n%2==0)return false;
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0)return false;
        }
        return true;
    }
}