class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=0;i<=n;i++){
            if(helper(i))count++;
        }
        return count;
    }public boolean helper(int n){
        boolean flag=false;
        while(n>0){
            int d=n%10;
            if(d==2||d==5||d==6||d==9)flag=true;
            if(d==3||d==4||d==7)return false;
            n/=10;
        }
        return flag;
    }
}