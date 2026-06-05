class Solution {
    public long totalWaviness(long num1, long num2) {
        String l=String.valueOf(num1-1);
        String r=num2+"";
        Long[][][][][][]dp1=new Long[3][11][11][r.length()+1][3][20];
        Long[][][][][][]dp2=new Long[3][11][11][l.length()+1][3][20];
        return helper(r,1,-1,-1,0,1,0,dp1)-helper(l,1,-1,-1,0,1,0,dp2);
        
    }public long helper(String s,int tight,int prev,int sprev,int idx,int lz,int count,Long[][][][][][]dp){
        if(idx==s.length())return count;
        int lb=0;
        long res=0;
        if(dp[tight][prev+1][sprev+1][idx][lz][count]!=null)return dp[tight][prev+1][sprev+1][idx][lz][count];
        int ub=tight==1?s.charAt(idx)-'0':9;
        for(int digit=lb;digit<=ub;digit++){
            int nt=tight==1&&digit==ub?1:0;
            if(lz==1&&digit==0){
                res+=helper(s,nt,prev,sprev,idx+1,lz,count,dp);
            }else{
                if(sprev!=-1&&sprev<prev&&prev>digit||sprev>prev&&prev<digit){
                    res+=helper(s,nt,digit,prev,idx+1,0,count+1,dp);
                }else{
                    res+=helper(s,nt,digit,prev,idx+1,0,count,dp);
                }
            }
        }
        return dp[tight][prev+1][sprev+1][idx][lz][count]= res;
    }
}