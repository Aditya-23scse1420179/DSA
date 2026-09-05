class Solution {
    int res=0;
    public int maxProduct(String s) {
        char[]arr=s.toCharArray();
        helper(arr,0,"","");
        return res;
    }public void helper(char[]arr,int idx,String s1,String s2){
        if(idx>=arr.length){
            if(ispal(s1)&&ispal(s2)){
                res=Math.max(res,s1.length()*s2.length());
            }
            return;
        }
        helper(arr,idx+1,s1+arr[idx],s2);
        helper(arr,idx+1,s1,s2+arr[idx]);
        helper(arr,idx+1,s1,s2);
    }public boolean ispal(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))return false;
        }
        return true;
    }
}