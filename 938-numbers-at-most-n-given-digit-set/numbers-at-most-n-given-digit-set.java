class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int mask=0;
        for(String x:digits){
            mask|=(1<<Integer.parseInt(x));
        }
        String s=String.valueOf(n);
        Integer[][][]dp=new Integer[s.length()+1][2][2];
        int ans =solve(s,0,1,1,mask,dp);
        return ans-1;
        
    }public int solve(String s,int idx,int tight,int lz,int mask,Integer[][][]dp){
        if(idx==s.length())return 1;
        if(dp[idx][tight][lz]!=null)return dp[idx][tight][lz];
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1&&digit==ub)?1:0;
            if(lz==1&&digit==0){
                res+=solve(s,idx+1,newtight,lz,mask,dp);
            }else{
                if(((mask>>digit)&1)==0)continue;
                res+=solve(s,idx+1,newtight,0,mask,dp);
            }    
        }
        return dp[idx][tight][lz]=res;
    }
}