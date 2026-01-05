class Solution {
    public int countDigitOne(int n) {
        String s=String.valueOf(n);
        Integer[][][]dp=new Integer[s.length()+1][2][11];
        return helper(s,0,1,0,dp);        
    }public int helper(String s,int idx,int tight,int count,Integer[][][]dp ){
        if(idx==s.length())return count;
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        int res=0;
        if(dp[idx][tight][count]!=null)return dp[idx][tight][count];
        for(int digit =lb;digit<=ub;digit++){
            int newtight=(tight==1&&digit==ub)?1:0;
            if(digit==1){
                res+=helper(s,idx+1,newtight,count+1,dp);
            }else{
                res+=helper(s,idx+1,newtight,count,dp);
            }
        }
        return dp[idx][tight][count]=res;
    }
}