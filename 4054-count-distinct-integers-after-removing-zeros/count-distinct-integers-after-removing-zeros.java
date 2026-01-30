class Solution {
    public long countDistinct(long n) {
        String s=String.valueOf(n);
        Long[][][]dp=new Long[20][2][2]; 
        return helper(0,1,1,s,dp);
    }public static Long helper(int idx,int tight,int lz,String s,Long[][][]dp){
        if(idx==s.length())return lz==1?0L:1;
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        long res=0;
        if(dp[idx][tight][lz]!=null)return dp[idx][tight][lz];
        for(int digit=0;digit<=ub;digit++){
            int nt=(tight==1&&digit==ub)?1:0;
            if(lz==1&&digit==0){
                res+=helper(idx+1,nt,lz,s,dp);
            }else{
                if(digit==0)continue;
                res+=helper(idx+1,nt,0,s,dp);
            }
        }
        return dp[idx][tight][lz]=res;
    }
}