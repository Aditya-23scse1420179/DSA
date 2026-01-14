class Solution {
    public int numDupDigitsAtMostN(int n){
        String s=String.valueOf(n);
        Integer[][][][][]dp=new Integer[s.length()+1][2][2][1024][2];
        int ans=solve(s,0,1,0,0,1,dp);
        return ans;
    }
    public static int solve(String s,int idx,int tight,int repeated,int mask,int lz,Integer[][][][][]dp){
        if(idx==s.length()){
            return repeated;
        }
        if(dp[idx][tight][repeated][mask][lz]!=null)return dp[idx][tight][repeated][mask][lz];
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        int res=0;
        for(int digit =lb;digit<=ub;digit++){
            int newtight=(tight==1&&digit==ub)?1:0;
            int nlz=(lz==1&&digit==0)?1:0;
            if(nlz==1){
                res+=solve(s,idx+1,newtight,repeated,mask,nlz,dp);
            }else{
                int isUsed =1&(mask>>digit);
                int newReapeted=(repeated==1||isUsed==1)?1:0;
                int newMask=(1<<(digit)|mask);
                res+=solve(s,idx+1,newtight,newReapeted,newMask,nlz,dp);
            }    
        }
        return dp[idx][tight][repeated][mask][lz]=res;
    }
}