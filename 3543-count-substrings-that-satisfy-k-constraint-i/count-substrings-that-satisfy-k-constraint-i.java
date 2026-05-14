class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
                int zero=0;
                int one=0;
            for(int j=i;j<n;j++){
                    if(s.charAt(j)=='0')zero++;
                    else one++;
                
                if(zero<=k||one<=k)ans++;
            }
        }
        return ans;
    }
}