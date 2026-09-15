class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length(),ans=0,end=-1;
        for(int i=0;i<n;i++){
            for(int len:new int[]{k,k+1}){
                int st=i-len+1;
                if(st>=0&&st>end&&ispal(s,st,i)){
                    ans++;
                    end=i;
                    break;
                }
            }
        }
        return ans;
    }public boolean ispal(String s,int left,int right){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--))return false;
        }
        return true;
    }
}