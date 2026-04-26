class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][]dp=new int[s1.length()+1][s2.length()+1];
        int n=s1.length();
        int m=s2.length();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+s1.charAt(i-1);//ascii value add karo insted of 1+
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int sum1=0,sum2=0;
        for(char c:s1.toCharArray())sum1+=c;
        for(char ch:s2.toCharArray())sum2+=ch;
        return (sum1+sum2-2*dp[n][m]);// upar ascii aa chuka hai aab total -seq-seq formed so total -2*seq
    }
}