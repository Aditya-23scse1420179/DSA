class Solution {
    public int findGCD(int[] nums) {
        int a=-(int)1e9;
        int b=(int)1e9;
        for(int x:nums){
            a=Math.max(a,x);
            b=Math.min(b,x);
        }
        return gcd(a,b);
    }
    public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}