class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(words,(a,b)->{
            return a.length()-b.length();
        });
        int max=0;
        for(int i=1;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(riyal(words[j],words[i])&&dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            if(dp[i]>dp[max]){
                max=i;
            }
        }
        return dp[max];
        
        
    }public boolean riyal(String prev,String curr){
        if(prev.length()+1 != curr.length()) return false;
        int i=0;int j=0;
        boolean flag=false;
        while(i<curr.length()){
            if(j<prev.length()&&prev.charAt(j)==curr.charAt(i)){
                i++;
                j++;
            }else{
                if(flag)return false;
                flag=true;
                i++;
            }
        }
        return true;
    }
}