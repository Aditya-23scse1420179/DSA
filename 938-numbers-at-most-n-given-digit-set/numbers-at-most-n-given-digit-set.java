class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        HashSet<Integer>set=new HashSet<>();
        for(String x:digits){
            set.add(Integer.parseInt(x));
        }
        String s=String.valueOf(n);
        Integer[][][]dp=new Integer[s.length()+1][2][2];
        int ans =solve(s,0,1,1,set,dp);
        return ans-1;
        
    }public int solve(String s,int idx,int tight,int lz,HashSet<Integer>set,Integer[][][]dp){
        if(idx==s.length())return 1;
        if(dp[idx][tight][lz]!=null)return dp[idx][tight][lz];
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1&&digit==ub)?1:0;
            if(lz==1&&digit==0){
                res+=solve(s,idx+1,newtight,lz,set,dp);
            }else{
                if(!set.contains(digit))continue;
                res+=solve(s,idx+1,newtight,0,set,dp);
            }    
        }
        return dp[idx][tight][lz]=res;
    }
}