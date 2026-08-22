class Solution {
    public boolean checkDivisibility(int n) {
        String s=String.valueOf(n);
        int su=0,m=1;
        for(int a:s.toCharArray()){
            su+=(a-'0');
            m*=(a-'0');
        }    
        return n%(su+m)==0;
    }
}