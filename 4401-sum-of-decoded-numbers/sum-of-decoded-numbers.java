import java.math.BigInteger;
class Solution {
    BigInteger MOD = BigInteger.valueOf(1000000007);
    public int sumDecoded(long[] nums) {
        long ans=0;
        for(int i=0;i<nums.length;i++){
            long n=nums[i];
            int w=(int)(n%10);
            long d=n/10;
            String s=String.valueOf(d);
            long x=Long.parseLong(s.substring(0,w));
            long y=Long.parseLong(s.substring(w));

            BigInteger base = BigInteger.valueOf(x);
            BigInteger exp = BigInteger.valueOf(y);
            long res = base.modPow(exp, MOD).longValue();

            ans=(ans+res)%1000000007;
        }
        return (int)ans;
    }
}