class Solution {
    public int smallestNumber(int n, int t) {
        int ans=0;
        for(int i=n;i<=100;i++){
            if(helper(i,t)){
                ans=i;
                break;
            }
        }
        return ans;
    }public boolean helper(int x,int t){
        String s=String.valueOf(x);
        int a=1;
        for(char c:s.toCharArray()){
            a*=c-'0';
            if(a%t==0)return true;
        }
        return false;
    }
}