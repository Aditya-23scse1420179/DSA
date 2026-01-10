class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        String s="9".repeat(n);
        Integer[][][][]dp=new Integer[s.length()+1][3][2][1024];
        return helper(s,0,1,1,0,dp);
    }public int helper(String s,int idx,int tight,int lz,int mask,Integer[][][][]dp){
        if(idx==s.length())return 1;
        if(dp[idx][tight][lz][mask]!=null)return dp[idx][tight][lz][mask];
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1&&digit==ub)?1:0;
            if(lz==1&&digit==0){
                res+=helper(s,idx+1,newtight,1,mask,dp);
            }else{
                if((mask&(1<<digit))!=0) continue;
                int newmask=mask|(1<<(digit));
                res+=helper(s,idx+1,newtight,0,newmask,dp);
            }
        }
        return dp[idx][tight][lz][mask]= res;
    }
}