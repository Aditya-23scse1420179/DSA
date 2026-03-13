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
                if(riyal(words[i],words[j])&&dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            if(dp[i]>dp[max]){
                max=i;
            }
        }
        return dp[max];
        
        
    }public boolean riyal(String prev,String curr){
        if(prev.length() != curr.length()+1) return false;
        int i=0;int j=0;
        boolean flag=false;
        while(j<prev.length()){
            if(i<curr.length()&&prev.charAt(j)==curr.charAt(i)){
                i++;
                j++;
            }else{
                if(flag)return false;
                flag=true;
                j++;
            }
        }
        return true;
    }
}