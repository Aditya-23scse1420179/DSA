class Solution {
    public int countDigitOne(int n) {
        String s=String.valueOf(n);
        Integer[][][]dp=new Integer[s.length()+1][2][10];
        return solve(s,0,1,0,dp);
    }
    public int solve(String s,int idx,int tight,int count,Integer[][][]dp ){
        if(idx==s.length())return count;
        if(dp[idx][tight][count]!=null)return dp[idx][tight][count];
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1&&digit==ub)?1:0;
            if(digit==1){
                res+=solve(s,idx+1,newtight,count+1,dp);
            }else{
                res+=solve(s,idx+1,newtight,count,dp);
            }
        }
        return dp[idx][tight][count]=res;
    }
}