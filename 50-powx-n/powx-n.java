class Solution {
    public double myPow(double x, long N) { 
        if (N < 0){
            return 1.0/ fastPow(x, -N);
        }
        return fastPow(x, N);
    }
    double fastPow(double x, long n) {
        if (n ==0) return 1.0;
        double half =fastPow(x, n /2);
        if (n % 2 == 0){
            return half*half;
        }else{
            return x* half *half;
        }
    }
}
