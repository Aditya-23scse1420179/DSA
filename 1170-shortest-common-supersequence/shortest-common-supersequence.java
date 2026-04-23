class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int [][]dp=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }StringBuilder sb=new StringBuilder();
        int n=s1.length(),m=s2.length();
        int r=n,c=m;
        while(r>0&&c>0){
            if(s1.charAt(r-1)==s2.charAt(c-1)){
                sb.append(s1.charAt(r-1));
                r--;
                c--;
            }else if(dp[r-1][c]>dp[r][c-1]){
                sb.append(s1.charAt(r-1));
                r--;
            }else{
                sb.append(s2.charAt(c-1));
                c--;
            }
        }
        while(r>0){
            sb.append(s1.charAt(r-1));
            r--;
        }
        while(c>0){
            sb.append(s2.charAt(c-1));
            c--;
        }
        return sb.reverse().toString();

    }
}