class Solution {
    Long[]dp;
    public int distinctSubseqII(String s) {
        dp=new Long[s.length()];
        char[]arr=s.toCharArray();
        return (int)helper(arr,0);
    }public long helper(char[]arr,int i){
        if(i>=arr.length)return 0;
        if(dp[i]!=null)return dp[i];
        Set<Character>set=new HashSet<>();
        long ans=0;
        for(int j=i;j<arr.length;j++){
            if(set.contains(arr[j]))continue;
            set.add(arr[j]);
            ans=(ans+1+helper(arr,j+1))%1000000007;
        }
        return dp[i]=ans;
    }
}