class Solution {
    Integer[][][]dp;
    public int findIntegers(int n) {
        String s=Integer.toBinaryString(n);
        dp=new Integer[s.length()+1][2][11];
        return helper(s,0,1,-1);
    }public int helper(String s,int idx,int tight,int prev){
        if(idx==s.length())return 1;
        int lb=0;
        if(dp[idx][tight][prev+1]!=null)return dp[idx][tight][prev+1];
        int ub=tight==1?s.charAt(idx)-'0':1;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int nt=tight==1&&digit==ub?1:0;
            if(digit==1&&prev==1)continue;
            res+=helper(s,idx+1,nt,digit);
        }
        return dp[idx][tight][prev+1]=res;
    }
}