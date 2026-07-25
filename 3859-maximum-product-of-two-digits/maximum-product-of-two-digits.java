class Solution {
    public int maxProduct(int n) {
        String s=String.valueOf(n);
        int ans=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                int max=(s.charAt(i)-'0')*(s.charAt(j)-'0');
                ans=Math.max(ans,max);
            }
        }
        return ans;
    }
}