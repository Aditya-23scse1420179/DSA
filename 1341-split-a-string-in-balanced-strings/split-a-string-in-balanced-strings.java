class Solution {
    public int balancedStringSplit(String s) {
        int f=0,ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R')f+=1;
            else if(s.charAt(i)=='L')f-=1;
            if(f==0)ans+=1;
        }
        return ans;
    }
}