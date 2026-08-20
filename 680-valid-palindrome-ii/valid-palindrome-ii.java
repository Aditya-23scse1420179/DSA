class Solution {
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return ispal(s,i+1,j)||ispal(s,i,j-1); 
            }
            i++;
            j--;
        }
        return true;
    }public boolean ispal(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))return false;
        }
        return true;
    }
}