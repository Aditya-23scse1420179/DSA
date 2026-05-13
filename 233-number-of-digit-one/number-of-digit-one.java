class Solution {
        Integer[][][]dp;
    public int countDigitOne(int n) {
        String s=String.valueOf(n);
        dp=new Integer[s.length()+1][2][11];
        return helper(s,0,1,0);
    }public int helper(String s,int idx,int tight,int count){
        if(idx==s.length())return count;
        int lb=0;
        int res=0;
        if(dp[idx][tight][count]!=null)return dp[idx][tight][count];
        int ub=tight==1?s.charAt(idx)-'0':9;
        for(int digit=lb;digit<=ub;digit++){
            int nt=tight==1&&digit==ub?1:0;
            if(digit==1){
                res+=helper(s,idx+1,nt,count+1);
            }else{
                res+=helper(s,idx+1,nt,count);
            }
        }
        return dp[idx][tight][count]= res;
    }
}