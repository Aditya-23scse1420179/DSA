class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int ls=0,lq=0,rs=0,rq=0;
        for(int i=0;i<n;i++){
            if(num.charAt(i)=='?'){
                if(i<n/2)lq++;
                else rq++;
            }else{
                if(i<n/2){
                ls+=num.charAt(i)-'0';
                }
                else
                rs+=num.charAt(i)-'0';
            }
        }
        if((lq+rq)%2!=0)return true;
        int left=2*ls+9*lq;
        int right=2*rs+9*rq;
        if(left==right)return false;
        else return true;
    }
}