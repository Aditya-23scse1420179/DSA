class Solution {
    public boolean validDigit(int n, int x) {
        String s=String.valueOf(n);
        if(s.charAt(0)-'0'!=x){
            for(char c:s.toCharArray()){
                if(c-'0'==x)return true;
            }
        }
        return false;
        
    }
}