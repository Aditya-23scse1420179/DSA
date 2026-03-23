class Solution {
    Integer[][][][][]dp;
    public int countSpecialNumbers(int n) {
        String s=String.valueOf(n);
        dp=new Integer[s.length()+1][2][2][1024][2];
        return helper(s,0,1,0,0,1)-1;
    }public int helper(String s,int idx,int tight,int repeated,int mask,int lz){
        if(idx==s.length())return repeated==0?1:0;
        int lb=0;
        if(dp[idx][tight][repeated][mask][lz]!=null)return dp[idx][tight][repeated][mask][lz];
        int ub=tight==1?s.charAt(idx)-'0':9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int nt=tight==1&&digit==ub?1:0;
            if(lz==1&&digit==0){
                res+=helper(s,idx+1,nt,repeated,mask,lz);
            }else{
                int isused=((mask>>digit)&1);
                int nr=repeated==1||isused==1?1:0;
                int nm=((1<<digit)|mask);
                res+=helper(s,idx+1,nt,nr,nm,0);
            }
        }
        return dp[idx][tight][repeated][mask][lz]= res;
    }
}